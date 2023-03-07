package com.z.work.es;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        atomicInteger.decrementAndGet();
        System.out.print(atomicInteger);
    }
}
