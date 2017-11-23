package com.christophstiefel.monitor;

import com.christophstiefel.monitor.service.ConnectionService;
import com.christophstiefel.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author chris
 */
@SpringBootApplication
@PropertySource("classpath:project.properties")
public class Run implements CommandLineRunner {

    
    @Autowired
    private MonitorService monitorService;
    
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Run.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
       monitorService.todo();
    }
}
