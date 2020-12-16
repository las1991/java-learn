package com.las.learn.concurrent.concurrentbook;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/3/4
 */
public class WaitTest {

    private static String a = "";

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new WaitTest().new TestTask());
        t.start();
        Thread.sleep(12000);
        for (int i = 5; i > 0; i--) {
            System.out.println("快唤醒挂起的线程************");
            Thread.sleep(1000);
        }
        System.out.println("收到，马上！唤醒挂起的线程************");
        synchronized (a) {
            a.notifyAll();
        }

    }


    class TestTask implements Runnable {
        public void run() {
            synchronized (a) {
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        System.out.println("我在运行 ***************");
                    }
                    a.wait();
                    for (int i=0;i<10;i++){
                        System.out.println("谢谢唤醒**********又开始运行了*******");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}