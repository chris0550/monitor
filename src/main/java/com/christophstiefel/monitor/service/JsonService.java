package com.christophstiefel.monitor.service;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class JsonService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T extends Object> T fileToObject(String filePath, Class<T> clazz) throws IOException {
        final Path path = Paths.get(filePath);
        return objectMapper.readValue(path.toFile(), clazz);
    }
}
