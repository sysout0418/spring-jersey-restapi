package com.example.demo.common.config;

import com.example.demo.api.controller.AlbumController;
import com.example.demo.api.controller.PlayListController;
import com.example.demo.api.controller.SearchController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(AlbumController.class);
        register(PlayListController.class);
        register(SearchController.class);
        //register(new ObjectMapperContextResolver(objectMapper));
    }

    /*@Provider
    public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
        private final ObjectMapper objectMapper;

        public ObjectMapperContextResolver(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return objectMapper;
        }
    }*/

}
