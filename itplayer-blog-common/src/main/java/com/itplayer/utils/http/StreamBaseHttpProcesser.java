package com.itplayer.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class StreamBaseHttpProcesser extends BaseHttpProcesser {

	public StreamBaseHttpProcesser(String url, InputStream inputStream) {
		super(url, inputStream);
	}

	public StreamBaseHttpProcesser(String url, InputStream inputStream, Map<String, String> headers) {
		super(url, inputStream);
		setHeaders(headers);
	}

	public StreamBaseHttpProcesser(String url, InputStream inputStream, int connectionTimeout, int timeOut) {
		super(url, inputStream);
		setConnectionTimeout(connectionTimeout);
		setTimeOut(timeOut);
	}

	public StreamBaseHttpProcesser(String url, InputStream inputStream, Map<String, String> headers, int connectionTimeout, int timeOut) {
		super(url, inputStream);
		setHeaders(headers);
		setConnectionTimeout(connectionTimeout);
		setTimeOut(timeOut);
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
		InputStreamEntity inputEntry = new InputStreamEntity(inputStream);
		post.setEntity(inputEntry);
		CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(post);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			String resutlStr = EntityUtils.toString(entity);
			return resutlStr;
		}
		return null;
	}
}
