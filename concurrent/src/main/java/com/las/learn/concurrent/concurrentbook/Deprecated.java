package com.las.learn.concurrent.concurrentbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/11
 */
public class Deprecated {

    public static void main(String[] args) {
        DateFormat format=new SimpleDateFormat("HH:mm:ss");
        Thread printThread=new Thread(new Runner(),"PrintThread");
        printThread.setDaemon(true);
        printThread.start();

        SleepUtils.second(3);
        //暂停，输出内容工作停止
        printThread.suspend();
        System.out.println("main suspend thread at :"+format.format(new Date()));
        SleepUtils.second(3);
        //恢复，输出内容继续
        printThread.resume();
        System.out.println("main resume thread at :"+format.format(new Date()));
        SleepUtils.second(3);
        //终止，输出内容停止
        printThread.stop();
        System.out.println("main stop thread at :"+format.format(new Date()));
        SleepUtils.second(3);
    }

    static class Runner implements Runnable{

        public void run() {
            DateFormat format=new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName()+" Run at "+format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
