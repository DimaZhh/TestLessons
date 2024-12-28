package org.api.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonMapper {

    private static final ObjectMapper jacksonMapper =
            com.fasterxml.jackson.databind.json.JsonMapper.builder()
                    .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                    .configure(JsonParser.Feature.ALLOW_COMMENTS, Boolean.TRUE)
                    .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                    .build()
                    .registerModule(new JavaTimeModule());

    public static ObjectMapper getJsonMapper() {
        return jacksonMapper;
    }
}
