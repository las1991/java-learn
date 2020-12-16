package com.las.learn.concurrent.concurrentbook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/4/15
 */
public class ConcurrentHashMapTest {

    public static void testHashMap() throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

    public static void testConcurrentHashMap() {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        public void run() {
                            map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                        }
                    }, "thread-" + i);
                }
            }
        }, "");
    }

    @Test
    public void test() {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
        Iterator iterator = hashMap.entrySet().iterator();
    }
}
