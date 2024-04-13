package com.jp.springbatchpoc.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@RequiredArgsConstructor
public class SpringRestConfiguration implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig, CorsRegistry cors) {

        ExposureConfiguration config = restConfig.getExposureConfiguration();
        config.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH));
        config.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PUT));
        config.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.POST));
        config.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.DELETE));

        Class<?>[] classes = entityManager.getMetamodel()
                .getEntities().stream().map(Type::getJavaType).toArray(Class[]::new);
        restConfig.exposeIdsFor(classes);
    }
}
