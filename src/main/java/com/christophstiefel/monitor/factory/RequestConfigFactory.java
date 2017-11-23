package com.christophstiefel.monitor.factory;

import com.christophstiefel.monitor.model.MonitorUrl;
import org.apache.http.client.config.RequestConfig;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class RequestConfigFactory {

    public RequestConfig create(final MonitorUrl monitorUrl) {
        final RequestConfig.Builder requestBuilder = RequestConfig.copy(RequestConfig.DEFAULT);
        requestBuilder.setConnectTimeout(monitorUrl.getTimeout());
        requestBuilder.setConnectionRequestTimeout(monitorUrl.getTimeout());
        requestBuilder.setSocketTimeout(monitorUrl.getTimeout());
        return requestBuilder.build();
    }
}
