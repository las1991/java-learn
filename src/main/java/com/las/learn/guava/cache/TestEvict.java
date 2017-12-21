package com.las.learn.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TestEvict {

    Cache<Integer, Integer> storageTimeCahe = CacheBuilder.newBuilder().maximumSize(10).build();

    @Test
    public void testEvict() {
        storageTimeCahe.put(1, 1);
        storageTimeCahe.put(2, 2);
        storageTimeCahe.put(3, 3);
        storageTimeCahe.put(4, 4);
        storageTimeCahe.put(5, 5);
        storageTimeCahe.put(6, 6);
        storageTimeCahe.put(7, 7);
        storageTimeCahe.put(8, 8);
        storageTimeCahe.put(9, 9);
        storageTimeCahe.put(10, 10);

        System.out.println(storageTimeCahe.asMap().toString());

        storageTimeCahe.getIfPresent(1);
        storageTimeCahe.getIfPresent(2);
        storageTimeCahe.getIfPresent(3);
        storageTimeCahe.getIfPresent(4);
        storageTimeCahe.getIfPresent(5);
        storageTimeCahe.getIfPresent(6);
        storageTimeCahe.getIfPresent(7);
        storageTimeCahe.getIfPresent(8);
        storageTimeCahe.getIfPresent(9);
        storageTimeCahe.put(11, 11);
        System.out.println(storageTimeCahe.asMap().toString());



    }

}
