package com.itplayer.utils.http;

import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public abstract class BaseHttpProcesser {

	int connectionTimeout = 3000;
	int timeOut = 3000;

	String url;
	Map<String, String> params;
	Object paramsObject;
	String strParams;
	Map<String, String> headers;
	InputStream inputStream;

	BaseHttpProcesser(String url, Map<String, String> params) {
		this.url = url;
		this.params = params;
	}

	BaseHttpProcesser(String url, Map<String, String> params, int connectionTimeout, int timeOut) {
		this.url = url;
		this.params = params;
		this.connectionTimeout = connectionTimeout;
		this.timeOut = timeOut;
	}

	public BaseHttpProcesser(String url, Map<String, String> params, Object paramsObject, String xmlStr, Map<String, String> headers) {

		this.url = url;
		this.params = params;
		this.paramsObject = paramsObject;
		this.strParams = xmlStr;
		this.headers = headers;
	}

	public BaseHttpProcesser(String url, Map<String, String> params, Object paramsObject, String xmlStr, Map<String, String> headers,
							 int connectionTimeout, int timeOut) {
		this.connectionTimeout = connectionTimeout;
		this.timeOut = timeOut;
		this.url = url;
		this.params = params;
		this.paramsObject = paramsObject;
		this.strParams = xmlStr;
		this.headers = headers;
	}

	public BaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers) {
		this.url = url;
		this.params = params;
		this.headers = headers;
	}

	public BaseHttpProcesser(String url, Map<String, String> params, Map<String, String> headers, int connectionTimeout, int timeOut) {
		this.url = url;
		this.params = params;
		this.headers = headers;
		this.connectionTimeout = connectionTimeout;
		this.timeOut = timeOut;
	}

	public BaseHttpProcesser(String url, InputStream inputStream) {
		this.url = url;
		this.inputStream = inputStream;
	}

	public BaseHttpProcesser(String url, String strParams) {
		this.url = url;
		this.strParams = strParams;
	}

	public BaseHttpProcesser(String url, String strParams, int connectionTimeout, int timeOut) {
		this.url = url;
		this.strParams = strParams;
		this.connectionTimeout = connectionTimeout;
		this.timeOut = timeOut;
	}

	public BaseHttpProcesser(String url, String strParams, Map<String, String> headers, int connectionTimeout, int timeOut) {
		this.url = url;
		this.strParams = strParams;
		this.headers = headers;
		this.connectionTimeout = connectionTimeout;
		this.timeOut = timeOut;
	}

	public BaseHttpProcesser(String url, String strParams, Map<String, String> headers) {
		this.url = url;
		this.strParams = strParams;
		this.headers = headers;
	}

	public abstract String doProcess(CloseableHttpClient httpClient) throws IOException;

	public BaseHttpProcesser() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Object getParamsObject() {
		return paramsObject;
	}

	public void setParamsObject(Object paramsObject) {
		this.paramsObject = paramsObject;
	}

	public String getStrParams() {
		return strParams;
	}

	public void setStrParams(String strParams) {
		this.strParams = strParams;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
}
