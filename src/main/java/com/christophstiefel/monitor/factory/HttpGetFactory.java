package com.christophstiefel.monitor.factory;

import com.christophstiefel.monitor.model.MonitorUrl;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class HttpGetFactory {

    @Autowired
    private RequestConfigFactory requestConfigFactory;

    public HttpGet create(final MonitorUrl monitorUrl) {
        final HttpGet httpGet = new HttpGet(monitorUrl.getUrl());
        adjustRequestConfig(httpGet, monitorUrl);
        return httpGet;
    }

    private void adjustRequestConfig(final HttpGet httpGet, final MonitorUrl monitorUrl) {
        final RequestConfig requestConfig = requestConfigFactory.create(monitorUrl);
        httpGet.setConfig(requestConfig);
    }
}
