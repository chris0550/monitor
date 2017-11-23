package com.christophstiefel.monitor.service;

import com.christophstiefel.monitor.model.MonitorUrl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class MonitorService {

    @Autowired
    private ConfigService configService;

    @Autowired
    private ConnectionService connectionService;

    public void todo() { //TODO: This method is just for testing.
        try {
            MonitorUrl monitorUrl = configService.getConfig().getUrls().get(0); 
            connectionService.checkUrl(monitorUrl);
        } catch (IOException ex) {
            Logger.getLogger(MonitorService.class.getName()).log(Level.SEVERE, null, ex);
        }
          
                
    }
}
