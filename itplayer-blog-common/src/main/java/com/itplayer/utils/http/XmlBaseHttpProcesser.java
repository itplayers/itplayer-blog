package com.itplayer.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class XmlBaseHttpProcesser extends BaseHttpProcesser {

    public XmlBaseHttpProcesser(String url, String strParams) {
        super(url, strParams);
    }

    public XmlBaseHttpProcesser(String url, String strParams, Map<String, String> headers) {
        super(url, strParams, headers);
    }

    public XmlBaseHttpProcesser(String url, String strParams, int connectionTimeout, int timeOut) {
        super(url, strParams, connectionTimeout, timeOut);
    }

    public XmlBaseHttpProcesser(String url, String strParams, Map<String, String> headers, int connectionTimeout, int timeOut) {
        super(url, strParams, headers, connectionTimeout, timeOut);
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
        ContentProducer cp = new ContentProducer() {
            @Override
            public void writeTo(OutputStream outstream) throws IOException {
                Writer writer = new OutputStreamWriter(outstream, "UTF-8");
                writer.write(strParams);
                writer.flush();
            }
        };
        post.setEntity(new EntityTemplate(cp));
        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(response.getEntity());
        }
        return null;
    }
}
