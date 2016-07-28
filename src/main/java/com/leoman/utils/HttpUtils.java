package com.leoman.utils;


import com.leoman.common.core.bean.Response;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by wangbin on 2015/3/25.
 */
public class HttpUtils {

    protected final static Log logger = LogFactory.getLog(HttpUtils.class);

    private static final CloseableHttpClient httpClient;

    public static final String CHARSET = "UTF-8";
    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    /**
     * 发送get请求
     * @param url  请求uri
     * @return
     */
    public static Response sendGet(String url){
        return sendGet(url,null);
    }

    /**
     * 发送get请求
     * @param url 请求uri
     * @param headers 请求头
     * @return
     */
    public static Response sendGet(String url,Map<String,String> headers){
        Response result = new Response();

        if(StringUtils.isBlank(url)){
            result.setError("url为空!");
            result.setStatus(false);
            return result;
        }
        HttpGet httpGet= new HttpGet(url);
        try {
            if(null!=headers){
                Set<String> keys =  headers.keySet();
                for(String key :keys){
                    httpGet.setHeader(key,headers.get(key));
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            result.setStatusCode(statusCode);
            if (statusCode != 200) {
                httpGet.abort();
                result.setError("返回状态错误，错误码:"+statusCode);
                result.setStatus(false);
                return result;
            }
            HttpEntity entity = response.getEntity();
            String content = null;
            if (entity != null){
                content = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            result.setStatus(true);
            result.setBody(content);
        } catch (Exception e) {
            result.setStatus(false);
            result.setError(e.getMessage());
            logger.error(e);
        }
        return result;

    }



    public static Response sendPost(String url, Map<String,String> params){
        Response result = new Response();

        if(StringUtils.isBlank(url)){
            result.setError("url为空!");
            result.setStatus(false);
            return result;
        }
        try {
            List<NameValuePair> pairs = null;
            if(params != null && !params.isEmpty()){
                pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
            }
            HttpPost httpPost = new HttpPost(url);
            if(pairs != null && pairs.size() > 0){
                httpPost.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            result.setStatusCode(statusCode);
            if (statusCode != 200) {
                httpPost.abort();
                result.setError("返回状态错误，错误码:"+statusCode);
                result.setStatus(false);
                return result;
            }
            HttpEntity entity = response.getEntity();
            String content = null;
            if (entity != null){
                content = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            result.setStatus(true);
            result.setBody(content);
        }catch (Exception e){
            result.setStatus(false);
            result.setError(e.getMessage());
            logger.error(e);
        }
        return result;

    }

    /**
     * 通过request获取用户ip
     * @param request
     * @return
     */
    public static String getUserIpByRequest(HttpServletRequest request){
        String ip = null;

        if (request.getHeader("x-forwarded-for") == null) {
            ip= request.getRemoteAddr();
        }else{
            ip= request.getHeader("x-forwarded-for");
        }
        if("127.0.0.1".equals(ip)){
            return null;
        }
        return ip;
    }



    /**
     * 发送post请求
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendPost4String(String url, Map<String,String> params){
        return  sendPost(url,params).getBody();
    }


    public static void main(String[] args) {
//        String url = "http://apis.baidu.com/heweather/weather/free";
        String url = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
        Map<String,String> params = new HashMap<>();
        params.put("apikey","259675a39509993b416b4d380ddffebe");
        Response response = sendGet(url+"?ip=117.89.35.58",params);

        System.out.println(response.getBody());

    }

}
