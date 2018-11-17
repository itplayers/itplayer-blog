package com.itplayer.utils.http;

import java.io.InputStream;
import java.util.Map;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class HttpClientTemplate {
    /**
     * 发送Get
     *
     * @param url    请求地址
     * @param params 参数
     * @return 返回结果字符串
     */
    public static String sendGet(String url, Map<String, String> params) {
        return HttpTemplate.process(new GetBaseHttpProcesser(url, params));
    }

    /**
     * 发送get
     *
     * @param url               请求地址
     * @param params            参数
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendGet(String url, Map<String, String> params, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new GetBaseHttpProcesser(url, params, connectionTimeout, timeOut));
    }

    /**
     * 发送GET
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 请求头
     * @return 返回结果字符串
     */
    public static String sendGet(String url, Map<String, String> params, Map<String, String> headers) {
        return HttpTemplate.process(new GetBaseHttpProcesser(url, params, headers));
    }

    /**
     * 发送get
     *
     * @param url               请求地址
     * @param params            参数
     * @param headers           请求头
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */

    public static String sendGet(String url, Map<String, String> params, Map<String, String> headers, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new GetBaseHttpProcesser(url, params, headers, connectionTimeout, timeOut));
    }

    /**
     * 发送Post
     *
     * @param url    请求地址
     * @param params 参数
     * @return 返回结果字符串
     */
    public static String sendPost(String url, Map<String, String> params) {
        return HttpTemplate.process(new PostBaseHttpProcesser(url, params));
    }

    /**
     * 发送Post
     *
     * @param url               请求地址
     * @param params            参数
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendPost(String url, Map<String, String> params, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new PostBaseHttpProcesser(url, params, connectionTimeout, timeOut));
    }

    /**
     * 发送Post
     *
     * @param url     请求地址
     * @param params  参数
     * @param headers 请求头
     * @return 返回结果字符串
     */
    public static String sendPost(String url, Map<String, String> params, Map<String, String> headers) {
        return HttpTemplate.process(new PostBaseHttpProcesser(url, params, headers));
    }

    /**
     * 发送Post
     *
     * @param url               请求地址
     * @param params            参数
     * @param headers           请求头
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendPost(String url, Map<String, String> params, Map<String, String> headers, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new PostBaseHttpProcesser(url, params, headers, connectionTimeout, timeOut));
    }
    
    /**
     * 发送XML字符串
     *
     * @param url    请求地址
     * @param xmlStr 参数
     * @return 返回结果字符串
     */
    public static String sendXmlScop(String url, final String xmlStr) throws Exception {
        return HttpTemplate.process(new XmlBaseHttpProcesser(url, xmlStr));
    }

    /**
     * 发送XML字符串
     *
     * @param url               请求地址
     * @param xmlStr            参数
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendXmlScop(String url, final String xmlStr, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new XmlBaseHttpProcesser(url, xmlStr, connectionTimeout, timeOut));
    }

    /**
     * 发送XML字符串
     *
     * @param url     请求地址
     * @param xmlStr  参数
     * @param headers 请求头
     * @return 返回结果字符串
     */
    public static String sendXmlScop(String url, Map<String, String> headers, final String xmlStr) {
        return HttpTemplate.process(new XmlBaseHttpProcesser(url, xmlStr, headers));
    }

    /**
     * 发送XML字符串
     *
     * @param url               请求地址
     * @param xmlStr            参数
     * @param headers           请求头
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendXmlScop(String url, Map<String, String> headers, final String xmlStr, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new XmlBaseHttpProcesser(url, xmlStr, headers, connectionTimeout, timeOut));
    }

    /**
     * 发送JSON字符串
     *
     * @param url     请求地址
     * @param jsonStr 参数
     * @return 返回结果字符串
     */
    public static String sendJsonData(String url, final String jsonStr) {
        return HttpTemplate.process(new JsonBaseHttpProcesser(url, jsonStr));
    }

    /**
     * 发送JSON字符串
     *
     * @param url               请求地址
     * @param jsonStr           参数
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendJsonData(String url, final String jsonStr, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new JsonBaseHttpProcesser(url, jsonStr, connectionTimeout, timeOut));
    }

    /**
     * 发送JSON字符串
     *
     * @param url     请求地址
     * @param jsonStr 参数
     * @param headers 请求头
     * @return 返回结果字符串
     */
    public static String sendJsonData(String url, Map<String, String> headers, final String jsonStr) {
        return HttpTemplate.process(new JsonBaseHttpProcesser(url, jsonStr, headers));
    }

    /**
     * 发送JSON字符串
     *
     * @param url               请求地址
     * @param jsonStr           参数
     * @param headers           请求头
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendJsonData(String url, Map<String, String> headers, final String jsonStr, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new JsonBaseHttpProcesser(url, jsonStr, headers, connectionTimeout, timeOut));
    }
    
    /**
     * 发送数据流
     *
     * @param url               请求地址
     * @param inputStream            流数据
     * @return 返回结果字符串
     */
    public static String sendStream(String url, InputStream inputStream) {
        return HttpTemplate.process(new StreamBaseHttpProcesser(url, inputStream));
    }
    
    /**
     * 发送数据流
     *
     * @param url               请求地址
     * @param inputStream            流数据
     * @param headers           请求头
     * @return 返回结果字符串
     */
    public static String sendStream(String url, InputStream inputStream, Map<String, String> headers) {
        return HttpTemplate.process(new StreamBaseHttpProcesser(url, inputStream, headers));
    }
    
    /**
     * 发送数据流
     *
     * @param url               请求地址
     * @param inputStream            流数据
     * @param headers           请求头
     * @param connectionTimeout 连接超时时间
     * @param timeOut           超时时间
     * @return 返回结果字符串
     */
    public static String sendStream(String url, InputStream inputStream, Map<String, String> headers, int connectionTimeout, int timeOut) {
        return HttpTemplate.process(new StreamBaseHttpProcesser(url, inputStream, headers, connectionTimeout, timeOut));
    }

}
