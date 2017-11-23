package com.christophstiefel.monitor.model;

import java.util.List;

/**
 *
 * @author chris
 */
public class Config {

    private int checkingInterval;
    private List<MonitorUrl> urls;

    public int getCheckingInterval() {
        return checkingInterval;
    }

    public List<MonitorUrl> getUrls() {
        return urls;
    }
}
