package com.las.learn.concurrent.threadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author las
 * @date 19-7-26
 */
public class AsyncIOTask implements Runnable {

    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            String getURL = "https://www.baidu.com/";
            URL getUrl = new URL(getURL);

            connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // empty loop
            }
        }

        catch (IOException e) {

        } finally {
            if(reader != null) {
                try {
                    reader.close();
                }
                catch(Exception e) {

                }
            }
            connection.disconnect();
        }

    }

}

