package com.jp.springbatchpoc.utils;

import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapUtils {

    public static <K, V> Map<K, V> zipListsToMap(@NonNull List<K> keyList, @NonNull List<V> valueList) {
        if (keyList.size() != valueList.size()) {
            throw new IllegalArgumentException("Key list ("
                    + keyList.size()
                    + ") and value list ("
                    + valueList.size()
                    + ") are not the same size.");
        }
        Map<K, V> zippedMap = new HashMap<>();
        for (int index = 0; index < valueList.size(); index++) {
            V value = valueList.get(index);
            zippedMap.put(keyList.get(index), value);
        }
        return zippedMap;
    }

    public static <K, O, V> Map<O, V> mutateKeys(
            Map<K, V> originalMap, Function<Map.Entry<K, V>, Optional<O>> mutationFn) {
        return originalMap.entrySet().stream()
                .flatMap(entry -> mutationFn
                        .apply(entry)
                        .flatMap(newValue ->
                                Optional.ofNullable(entry.getValue()).map(value -> Map.entry(newValue, value)))
                        .stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, O, V> Map<K, O> mutateValues(
            Map<K, V> originalMap, Function<Map.Entry<K, V>, Optional<O>> mutationFn) {
        return originalMap.entrySet().stream()
                .flatMap(entry -> mutationFn.apply(entry).map(newValue -> Map.entry(entry.getKey(), newValue)).stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <K, V> Map<K, V> entryListToMap(List<Map.Entry<K, V>> entryList) {
        return entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
