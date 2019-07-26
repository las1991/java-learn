package com.las.learn.concurrent.threadPool;

/**
 * @author las
 * @date 19-7-25
 */
public class MyTask implements Runnable{
    private String name;
    private int count;
    public MyTask(String name, int count) {
        this.name = name;
        this.count = count;
    }
    public void run() {
        String[] strArray = new String[count];
        System.out.println("Start MyTask (" + name + "), loop count " + count);
        for (int i = 0; i < count; i++) {
            strArray[i]= "String " + (i * 10);
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (String str : strArray) {
            sb.append(str).append("\n");
            i++;
            if (i == count/2) {
                //sleep so that main thread can catch up to calculate the cpu times
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + " done");
    }

}
