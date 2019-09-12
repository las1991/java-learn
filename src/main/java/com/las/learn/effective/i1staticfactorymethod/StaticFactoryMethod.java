package com.las.learn.effective.i1staticfactorymethod;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;

/**
 * @author las
 */
public class StaticFactoryMethod {

    enum Rank {
        JACK, QUEEN, KING;
    }

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    @Test
    public void test() throws IOException {
        Boolean.valueOf(true);
        Date d = Date.from(Instant.now());
        Set<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        Object newArray = Array.newInstance(Integer.class, 10);
        FileStore fs = Files.getFileStore(Paths.get(""));
        BufferedReader br = Files.newBufferedReader(Paths.get(""));
        List<Object> litany = Collections.list(null);
    }
}
