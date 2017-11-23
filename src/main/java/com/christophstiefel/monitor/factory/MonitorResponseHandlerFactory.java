/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christophstiefel.monitor.factory;

import com.christophstiefel.monitor.handler.MonitorResponseHandler;
import com.christophstiefel.monitor.model.MonitorUrl;
import com.christophstiefel.monitor.model.MonitorUrlCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class MonitorResponseHandlerFactory {

    @Autowired
    private MonitorUrlCheckFactroy monitorUrlCheckFactroy;

    public MonitorResponseHandler create(final MonitorUrl monitorUrl) {
        final MonitorUrlCheck monitorUrlCheck = monitorUrlCheckFactroy.create(monitorUrl);
        return new MonitorResponseHandler(monitorUrlCheck);
    }
}
