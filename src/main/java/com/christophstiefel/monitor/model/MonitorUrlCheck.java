package com.christophstiefel.monitor.model;

import java.time.LocalDateTime;

/**
 *
 * @author chris
 */
public class MonitorUrlCheck {

    private MonitorUrl monitorUrl;
    private LocalDateTime time;
    private boolean successful;

    public MonitorUrl getMonitorUrl() {
        return monitorUrl;
    }

    public void setMonitorUrl(MonitorUrl monitorUrl) {
        this.monitorUrl = monitorUrl;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
