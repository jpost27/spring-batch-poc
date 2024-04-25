package com.jp.springbatchpoc.cache;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.jp.springbatchpoc.constants.Files;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class CacheLoader {

    private static final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .addModule(new Jdk8Module())
            .build();

    static {
        if (!Files.CACHE_DIRECTORY.exists()) {
            Files.CACHE_DIRECTORY.mkdir();
        }
    }

    public static <T> T loadOrFetch(@NonNull Cache cacheName, @NonNull TypeReference<T> tTypeReference, @NonNull Supplier<T> fetchFn) {
        File cacheFile = new File(Files.CACHE_DIRECTORY.getAbsolutePath() + "/" + cacheName);
        Optional<T> cachedData = readFromCache(cacheName, cacheFile, tTypeReference);
        if (cachedData.isPresent()) {
            return cachedData.get();
        }
        T response = fetchFn.get();
        writeToCache(cacheName, cacheFile, response);
        return response;
    }

    public static <T, I> T loadOrFetch(@NonNull Cache cacheName,
                                       @NonNull I id,
                                       @NonNull TypeReference<T> tTypeReference,
                                       @NonNull Function<I, T> fetchFn) {
        File cacheFile =
                new File(Files.CACHE_DIRECTORY.getAbsolutePath() + "/" + cacheName + "/" +
                        Base64.getUrlEncoder().encodeToString(id.toString().getBytes()));
        Optional<T> cachedData = readFromCache(cacheName, cacheFile, tTypeReference);
        if (cachedData.isPresent()) {
            return cachedData.get();
        }
        T response = fetchFn.apply(id);
        writeToCache(cacheName, cacheFile, response);
        return response;
    }

    public static <T> Mono<T> loadOrFetchMono(@NonNull Cache cacheName, @NonNull TypeReference<T> tTypeReference, @NonNull Supplier<Mono<T>> fetchFn) {
        File cacheFile = new File(Files.CACHE_DIRECTORY.getAbsolutePath() + "/" + cacheName);
        Optional<T> cachedData = readFromCache(cacheName, cacheFile, tTypeReference);
        return cachedData.map(Mono::justOrEmpty)
                .orElseGet(() -> fetchFn.get()
                        .doOnSuccess(res -> writeToCache(cacheName, cacheFile, res)));
    }

    public static <T, I> Mono<T> loadOrFetchMono(@NonNull Cache cacheName,
                                                 @NonNull I id,
                                                 @NonNull TypeReference<T> tTypeReference,
                                                 @NonNull Function<I, Mono<T>> fetchFn) {
        File cacheFile =
                new File(Files.CACHE_DIRECTORY.getAbsolutePath() + "/" + cacheName + "/" +
                        Base64.getUrlEncoder().encodeToString(id.toString().getBytes()));
        Optional<T> cachedData = readFromCache(cacheName, cacheFile, tTypeReference);
        return cachedData.map(Mono::justOrEmpty)
                .orElseGet(() -> fetchFn.apply(id)
                        .doOnSuccess(res -> writeToCache(cacheName, cacheFile, res)));
    }

    private static <T> Optional<T> readFromCache(Cache cacheName, File cacheFile, TypeReference<T> tTypeReference) {

        cacheFile = addFileExtension(cacheName, cacheFile);
        Optional<T> cacheRead = Optional.empty();
        if (cacheFile.exists()) {
            try {
                if (tTypeReference.getType().getTypeName().equals(String.class.getTypeName())) {
                    try (FileInputStream inputStream = new FileInputStream(cacheFile)) {
                        cacheRead = Optional.of((T) new String(inputStream.readAllBytes()));
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    cacheRead = Optional.of(objectMapper.readValue(cacheFile, tTypeReference));
                }
            } catch (IOException e) {
                log.error("Could not load cache {}. {}", cacheFile.getAbsolutePath(), e.getMessage());
                e.printStackTrace();
            }
        }
        cacheRead.ifPresent(value -> log.info("{} found in cache.", cacheName.name()));
        return cacheRead;
    }

    private static <T> void writeToCache(Cache cacheName, File cacheFile, T data) {
        if (data == null) {
            return;
        }
        cacheFile = addFileExtension(cacheName, cacheFile);
        cacheFile.getParentFile().mkdir();
        if (data instanceof String) {
            try (FileOutputStream outputStream = new FileOutputStream(cacheFile)) {
                outputStream.write(data.toString().getBytes());
            } catch (Exception e) {
                log.error("Could not save cache {}. {}", cacheFile.getAbsolutePath(), e.getMessage());
                e.printStackTrace();
            }
        } else {
            try {
                objectMapper.writeValue(cacheFile, data);
            } catch (IOException e) {
                log.error("Could not save cache {}. {}", cacheFile.getAbsolutePath(), e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static File addFileExtension(Cache cache, File file) {
        String extension = "";
        if (cache.getMediaType().equals(MediaType.APPLICATION_JSON)) {
            extension = ".json";
        }
        return new File(file.getPath() + extension);
    }

}
