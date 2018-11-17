package com.itplayer.utils.http;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class PostBaseHttpProcesser extends BaseHttpProcesser {
    public PostBaseHttpProcesser(String url, Map<String, String> params) {
        super(url, params);
    }

    public PostBaseHttpProcesser(String url, Map<String, String> params, int connectionTimeout, int timeOut) {
        super(url, params, connectionTimeout, timeOut);
    }

    public PostBaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers) {
        super(url, params, headers);
    }

    public PostBaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers, int connectionTimeout, int timeOut) {
        super(url, params, headers, connectionTimeout, timeOut);
    }

    @Override
    public String doProcess(CloseableHttpClient httpClient) throws IOException {
        httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                post.setHeader(entry.getKey(),entry.getValue());
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(connectionTimeout).build();
        post.setConfig(requestConfig);
        List<NameValuePair> formparams = paseToFormParam(params);
        UrlEncodedFormEntity encodeEntity;
        encodeEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        post.setEntity(encodeEntity);
        CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            String resutlStr = EntityUtils.toString(entity);
            return resutlStr;
        }
        return null;
    }

    /**
     * 解析参数的方法
     *
     * @param params
     * @return
     */
    public static List<NameValuePair> paseToFormParam(Map<String, String> params) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return formparams;
    }
}
