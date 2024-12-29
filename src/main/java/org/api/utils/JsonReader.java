package org.api.utils;

import static org.api.utils.JsonMapper.getJsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.common.io.Resources;
import groovy.util.logging.Slf4j;
import java.io.IOException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonReader {

    private static final ObjectMapper mapper = getJsonMapper();

    public static <T> T getDataFromJson(Class<T> clazz, String path) {
        URL file = Resources.getResource(path);
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException ioException) {
            throw new UnsupportedOperationException(ioException.getMessage());
        }
    }
}
