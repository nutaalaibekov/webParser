package com.nutaalaibekov.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpUtil {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private HttpUtil(){}

    public static String get(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            HttpGet request = new HttpGet(url);
            request.addHeader(HttpHeaders.USER_AGENT, USER_AGENT);

            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
