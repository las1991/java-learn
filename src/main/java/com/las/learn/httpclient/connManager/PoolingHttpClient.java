package com.las.learn.httpclient.connManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.concurrent.*;

public class PoolingHttpClient {

    private final static int CONNECTION_REQUEST_TIMEOUT = 10 * 1000;
    private final static int SOCKET_TIMEOUT = 5 * 1000;
    private final static int CONNECTION_TIMEOUT = 10 * 1000;
    private static HttpClient client;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(200);
        cm.setMaxTotal(200);
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        client = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .setConnectionManager(cm)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
                .setConnectionTimeToLive(60, TimeUnit.SECONDS)
                .evictIdleConnections(CONNECTION_REQUEST_TIMEOUT + CONNECTION_TIMEOUT + SOCKET_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();

    }

    public void post() {
//        String url = "http://localhost";
        String url = "http://jx1-test.cloud.sengled.com:8000/camera/";
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = client.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String responseText = EntityUtils.toString(httpEntity);
            System.out.println(System.currentTimeMillis() + ":" + responseText.length());
        } catch (Exception e) {
        } finally {
        }
    }

    public void postJson() {
        String json = "{\"appCode\":\"snap\",\"baiduChanelToken\":\"\",\"baiduUserToken\":\"\",\"gcmToken\":\"\",\"jsessionId\":\"\",\"osType\":\"android\",\"productCode\":\"snap\",\"pwd\":\"123456\",\"user\":\"las@sengled.com\",\"uuid\":\"3083bff77fea0945\",\"xgToken\":\"UM\"}";
        String url = "http://jx1-test.cloud.sengled.com:8000/user/app/customer/AuthenCross.json";
        try {
            HttpPost post = new HttpPost(url);
            HttpEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            post.setEntity(entity);
            HttpResponse httpResponse = client.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            String responseText = EntityUtils.toString(httpEntity);
            System.out.println(System.currentTimeMillis() + ":" + responseText.length());
        } catch (Exception e) {
        } finally {
        }
    }

    @Test
    public void testTimeWait() {
        CountDownLatch count = new CountDownLatch(2000);
        System.out.println("start test ");
        long start = System.currentTimeMillis();

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 2000; i++) {
            pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Thread.sleep(1000);
                    postJson();
                    count.countDown();
                    return null;
                }
            });
        }

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("end test cost:" + (end - start));
    }
}
