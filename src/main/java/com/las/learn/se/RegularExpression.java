package com.las.learn.se;

import static org.junit.Assert.*;
import org.junit.Test;

public class RegularExpression {

    @Test
    public void splite(){
        String expect="abc";
        assertTrue(expect.equals("abc&live.sdp".split("[&?]+")[0]));
        assertTrue(expect.equals("abc?live.sdp".split("[&?]+")[0]));
        assertTrue(expect.equals("abc??live.sdp".split("[&?]+")[0]));
        assertTrue(expect.equals("abc".split("[&?]+")[0]));
        assertTrue(expect.equals("abc&?&&&".split("[&?]+")[0]));
        assertTrue("".equals("".split("[&?]+")[0]));

    }

}
