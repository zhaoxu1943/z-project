package com.z.work.redis;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.BitSetBloomFilter;
import cn.hutool.bloomfilter.BloomFilterUtil;

public class TestBloom {


    public static void main(String[] args) {
        BitSetBloomFilter bitSet = BloomFilterUtil.createBitSet(1000, 100, 10);
        bitSet.add("123");
        bitSet.add("456");
        bitSet.add("789");
        System.out.println(bitSet.contains("123"));
        System.out.println(bitSet.contains("456"));
        System.out.println(bitSet.contains("789"));
        System.out.println(bitSet.contains("000"));

        BitMapBloomFilter bitMap = BloomFilterUtil.createBitMap(100);
        bitMap.add("123");
        bitMap.add("456");
        bitMap.add("789");
        System.out.println(bitMap.contains("123"));
        System.out.println(bitMap.contains("456"));
        System.out.println(bitMap.contains("789"));
        System.out.println(bitMap.contains("000"));
    }
}
