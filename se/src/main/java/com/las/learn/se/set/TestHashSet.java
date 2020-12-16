package com.las.learn.se.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    private class SameHash {
        private int val;

        public SameHash(int val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof SameHash) {
                return ((SameHash) obj).val == this.val;
            }
            return false;
        }
    }

    @Test
    public void testHashSet() {
        Set<Object> set = new HashSet<>();
        //10000
        set.add(new SameHash(1));
        set.add(new SameHash(1));
        set.add(new SameHash(2));
        set.add(new SameHash(3));
        System.out.println(set.size());
    }
}
