package com.christophstiefel.monitor.service;

import com.christophstiefel.monitor.factory.HttpGetFactory;
import com.christophstiefel.monitor.factory.MonitorResponseHandlerFactory;
import com.christophstiefel.monitor.model.MonitorUrl;
import com.christophstiefel.monitor.model.MonitorUrlCheck;
import java.io.IOException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class ConnectionService {

    @Autowired
    private HttpGetFactory httpGetFactory;

    @Autowired
    private MonitorResponseHandlerFactory monitorResponseHandlerFactory;

    private final CloseableHttpClient httpclient = HttpClients.createDefault();

    public MonitorUrlCheck checkUrl(final MonitorUrl monitorUrl) throws IOException {
        final HttpGet httpGet = httpGetFactory.create(monitorUrl);
        final ResponseHandler<MonitorUrlCheck> responseHandler = monitorResponseHandlerFactory.create(monitorUrl);
        return httpclient.execute(httpGet, responseHandler);
    }
}
