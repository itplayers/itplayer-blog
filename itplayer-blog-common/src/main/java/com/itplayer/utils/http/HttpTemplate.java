package com.itplayer.utils.http;

import com.itplayer.utils.exception.AmtToolException;
import org.apache.http.ParseException;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public abstract class HttpTemplate {
    public static String process(BaseHttpProcesser httpProcesser) {
        AmtToolException exception = null;
        CloseableHttpClient httpClient = null;
        String result = "";
        try {
            result = httpProcesser.doProcess(httpClient);
        } catch (IOException e) {
            exception = new AmtToolException("IOException", e.getMessage());
        } catch (ParseException e) {
            exception = new AmtToolException("ParseException", e.getMessage());
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                    exception = new AmtToolException("ConnectionException", "close httpConnection faild");
                }
            }
            if (exception != null) {
                throw new AmtToolException("Sent http faild![" + exception + "]" + exception.getMessage());
            }
        }
        return result;
    }


}

