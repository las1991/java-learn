package com.las.learn.httpclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParser;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

public class PoolConnUtil {
    private static Integer CONNECTION_TIMEOUT = 2 * 1000; //设置请求超时5秒钟 根据业务调整
    private static Integer SO_TIMEOUT = 2 * 1000; //设置等待数据超时时间5秒钟 根据业务调整
    private static PoolingHttpClientConnectionManager connManager;
    private static RequestConfig defaultRequestConfig;

    static {

        // Use custom message parser / writer to customize the way HTTP
        // messages are parsed from and written out to the data stream.
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {

            @Override
            public HttpMessageParser<HttpResponse> create(
                SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {

                    @Override
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }

                };
                return new DefaultHttpResponseParser(
                    buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {

                    @Override
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        // try to ignore all garbage preceding a status line infinitely
                        return false;
                    }

                };
            }

        };
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

        // Use a custom connection factory to customize the process of
        // initialization of outgoing HTTP connections. Beside standard connection
        // configuration parameters HTTP connection factory can define message
        // parser / writer routines to be employed by individual connections.
        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
            requestWriterFactory, responseParserFactory);
        SSLContext sslcontext = SSLContexts.createSystemDefault();

        // Create a registry of custom connection socket factories for supported
        // protocol schemes.
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.INSTANCE)
            .register("https", new SSLConnectionSocketFactory(sslcontext))
            .build();

        // Use custom DNS resolver to override the system DNS resolution.
        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {

            @Override
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("localhost")) {
                    return new InetAddress[]{InetAddress.getByAddress(new byte[]{127, 0, 0, 1})};
                } else {
                    return super.resolve(host);
                }
            }

        };

        // Create a connection manager with custom configuration.
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
            socketFactoryRegistry, connFactory, dnsResolver);
        connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(200); //设置整个连接池最大连接数 根据自己的场景决定
        connManager.setDefaultMaxPerRoute(20);

        defaultRequestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(CONNECTION_TIMEOUT)
            .setConnectTimeout(CONNECTION_TIMEOUT)
            .setSocketTimeout(SO_TIMEOUT)
            .setCircularRedirectsAllowed(true)
            .build();
    }

    /**
     * 获取定制版的httpClient实例
     */
    private static HttpClientBuilder clientBuilder() {
        return HttpClients.custom()
            .setConnectionManager(connManager)
            .setConnectionManagerShared(true)
            .setDefaultRequestConfig(defaultRequestConfig);
    }

    public static String sendGet(String url) {
        String responseText = "";
        CloseableHttpClient httpClient = clientBuilder().build();
        try {
            long startAt = System.currentTimeMillis();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            responseText = EntityUtils.toString(httpEntity);
            long cost = System.currentTimeMillis() - startAt;

            logger.info("GET {},cost {}ms. {} ,{}", url, cost,
                httpResponse.getStatusLine().getStatusCode(), responseText);
        } catch (Exception e) {
            logger.error("{},{}", e.getClass().getName(), e.getMessage());
            logger.error(e.getMessage(), e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }

        return responseText;
    }

}
