package com.christophstiefel.monitor.service;

import com.christophstiefel.monitor.model.Config;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class ConfigService {

    @Value("${config.file}")
    private String configPath;

    @Autowired
    private JsonService jsonService;

    private Config config;

    @PostConstruct
    private void init() throws IOException {
        loadConfig();
    }

    private void loadConfig() throws IOException {
        config = jsonService.fileToObject(configPath, Config.class);
    }

    public Config getConfig() {
        return config;
    }
}
