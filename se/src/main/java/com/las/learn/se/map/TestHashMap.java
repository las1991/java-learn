package com.las.learn.se.map;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author las
 * @date 19-6-28
 */
public class TestHashMap {
    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap();
        map.put("a", 1);
        Integer old = map.put(new String("a"), new Integer(1));
        assert old == 1;
        assert 1 == map.get("a");
    }
}
