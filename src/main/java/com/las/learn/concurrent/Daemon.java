package com.las.learn.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/10
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        public void run() {
            try{
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.printf("DaemonThread finally run.");
            }
        }
    }
}
