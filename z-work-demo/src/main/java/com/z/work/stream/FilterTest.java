package com.z.work.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        List<String> stringList2 = stringList.stream().filter(str->"2".equals(str)).collect(Collectors.toList());
        System.out.println(stringList2);
    }
}
