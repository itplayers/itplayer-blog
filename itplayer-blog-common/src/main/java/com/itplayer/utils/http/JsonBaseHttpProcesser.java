package com.itplayer.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class JsonBaseHttpProcesser extends BaseHttpProcesser {


    public JsonBaseHttpProcesser(String url, String strParams) {
        super(url, strParams);
    }

    public JsonBaseHttpProcesser(String url, String strParams, Map<String, String> headers) {
        super(url, strParams, headers);
    }

    public JsonBaseHttpProcesser(String url, String strParams, int connectionTimeout, int timeOut) {
        super(url, strParams, connectionTimeout, timeOut);
    }

    public JsonBaseHttpProcesser(String url, String strParams, Map<String, String> headers, int connectionTimeout, int timeOut) {
        super(url, strParams, headers, connectionTimeout, timeOut);
    }
    @Override
    public String doProcess(CloseableHttpClient httpClient) throws IOException {
        httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(connectionTimeout).build();
        post.setConfig(requestConfig);

        post.addHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Accept", "application/json");
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                post.setHeader(entry.getKey(),entry.getValue());
            }
        }
        post.setEntity(new StringEntity(strParams, Charset.forName("UTF-8")));
        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            String resutlStr = EntityUtils.toString(entity);
            return resutlStr;
        }
        return null;
    }
}
