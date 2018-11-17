package com.itplayer.utils.http;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class GetBaseHttpProcesser extends BaseHttpProcesser {
    public GetBaseHttpProcesser(String url, Map<String, String> params) {
        super(url, params);
    }

    public GetBaseHttpProcesser(String url, Map<String, String> params, int connectionTimeout, int timeOut) {
        super(url, params, connectionTimeout, timeOut);
    }

    public GetBaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers) {
        super(url, params, headers);
    }

    public GetBaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers, int connectionTimeout, int timeOut) {
        super(url, params, headers, connectionTimeout, timeOut);
    }

    @Override
    public String doProcess(CloseableHttpClient httpClient) throws IOException {
        String result = null;
        if (params != null && params.size() > 0) {
            url += "?";
            int index = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (0 != index++) {
                    url += "&";
                }
                url += (entry.getKey() + "=" + entry.getValue());
            }
        }
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(),entry.getValue());
            }
        }
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(connectionTimeout).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        return result;
    }

}
