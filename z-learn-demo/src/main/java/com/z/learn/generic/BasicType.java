package com.z.learn.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 泛型可以使用基础数据类型:
 * 优点: 减少box,unbox开销
 *
 * @author zhaoxu
 * @date 2/23/2023 2:46 PM
 * @since
 */
public class BasicType {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.print(list);
    }

}
