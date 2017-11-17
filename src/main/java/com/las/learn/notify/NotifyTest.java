package com.las.learn.notify;

/**
 * Created by las on 2016/12/26.
 */
public class NotifyTest {

    private static Boolean flag = true;
    private static Integer[] arr = new Integer[]{0, 1, 2};

    static class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            synchronized (arr){
                System.out.println(getName()+":notify"+System.currentTimeMillis()/1000);
                arr.notify();
                System.out.println(getName()+":notify end"+System.currentTimeMillis()/1000);
            }
        }
    }

    static class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
            while (flag) {
                try {
                    synchronized (arr) {
                        System.out.println(getName()+":get lock"+System.currentTimeMillis()/1000);
                        arr.wait(3000);
                        System.out.println(getName()+":Sleeped"+System.currentTimeMillis()/1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread w1=new WaitThread("w1");
        WaitThread w2=new WaitThread("w2");
        NotifyThread n1=new NotifyThread("n1");
        w1.start();
        w2.start();
        n1.start();
    }
}
