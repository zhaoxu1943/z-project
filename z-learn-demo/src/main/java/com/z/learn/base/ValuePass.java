package com.z.learn.base;


import lombok.extern.slf4j.Slf4j;

/**
 * 验证java 和 c的值传递特性
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
@Slf4j
public class ValuePass {

    public static void main(String[] args) {
        //int:铁值传递
        int x = 3;
        int y = 2;
        swap(x,y);
        log.info("x:{},y:{}",x,y);

        //String:同样的值传递
        String s1 = "abc";
        String s2 = "hij";
        swap(s1,s2);
        log.info("s1:{},s2:{}",s1,s2);

        //对象,如arr,是真的变了
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2};
        swapFirstElement(arr1,arr2);
        log.info("arr1[0]:{},arr2[0]:{}",arr1[0],arr2[0]);
    }

    private static void swapFirstElement(int[] arr1, int[] arr2) {
        int temp = arr1[0];
        arr1[0] = arr2[0];
        arr2[0] = temp;
    }

    private static void swap(int x,int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    private static void swap(String x,String y) {
        String temp = x;
        x = y;
        y = temp;
    }
}
