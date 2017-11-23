package com.christophstiefel.monitor.factory;

import com.christophstiefel.monitor.model.MonitorUrl;
import com.christophstiefel.monitor.model.MonitorUrlCheck;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class MonitorUrlCheckFactroy {

    public MonitorUrlCheck create(final MonitorUrl monitorUrl) {
        final MonitorUrlCheck monitorUrlCheck = new MonitorUrlCheck();
        monitorUrlCheck.setMonitorUrl(monitorUrl);
        return monitorUrlCheck;
    }
}
