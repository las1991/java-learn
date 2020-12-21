package com.las.learn.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * @auther: liansheng
 * @Date: 2020/12/16 20:54
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        // 1. Create config object
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

        // or read config from file
//        config = Config.fromYAML(new File("config-file.yaml"));

        // 2. Create Redisson instance

        // Sync and Async API
        RedissonClient redisson = Redisson.create(config);

        // Reactive API
        RedissonReactiveClient redissonReactive = Redisson.createReactive(config);

        // RxJava2 API
        RedissonRxClient redissonRx = Redisson.createRx(config);

        // 3. Get Redis based implementation of java.util.concurrent.ConcurrentMap
//        RMap<MyKey, MyValue> map = redisson.getMap("myMap");

//        RMapReactive<MyKey, MyValue> mapReactive = redissonReactive.getMap("myMap");

//        RMapRx<MyKey, MyValue> mapRx = redissonRx.getMap("myMap");

        // 4. Get Redis based implementation of java.util.concurrent.locks.Lock
        RLock lock = redisson.getLock("myLock");
        lock.lock();

        RLockReactive lockReactive = redissonReactive.getLock("myLock");

        RLockRx lockRx = redissonRx.getLock("myLock");

        // 4. Get Redis based implementation of java.util.concurrent.ExecutorService
        RExecutorService executor = redisson.getExecutorService("myExecutorService");

        // over 50 Redis based Java objects and services ...
    }
}
