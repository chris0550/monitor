package com.christophstiefel.monitor.handler;

import com.christophstiefel.monitor.model.MonitorUrlCheck;
import java.time.LocalDateTime;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;

/**
 *
 * @author chris
 */
public class MonitorResponseHandler implements ResponseHandler<MonitorUrlCheck> {

    private final MonitorUrlCheck monitorUrlCheck;

    public MonitorResponseHandler(final MonitorUrlCheck monitorUrlCheck) {
        this.monitorUrlCheck = monitorUrlCheck;
    }

    @Override
    public MonitorUrlCheck handleResponse(final HttpResponse httpResponse) {
        updateTime();
        checkHttpStatus(httpResponse);
        return monitorUrlCheck;
    }

    private void updateTime() {
        monitorUrlCheck.setTime(LocalDateTime.now());
    }

    private void checkHttpStatus(final HttpResponse httpResponse) {
        final int httpStatus = httpResponse.getStatusLine().getStatusCode();
        checkHttpStatus(httpStatus);
    }

    private void checkHttpStatus(int httpStatus) {
        final boolean successStatus = httpStatus >= 200 && httpStatus < 300
                || httpStatus == HttpStatus.SC_MOVED_TEMPORARILY;
        monitorUrlCheck.setSuccessful(successStatus);
    }

}
