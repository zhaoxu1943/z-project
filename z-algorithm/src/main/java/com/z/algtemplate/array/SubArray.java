package com.z.algtemplate.array;

import com.z.alg.util.PrintUtil;

/**
 * 模板: 如何遍历一个子数组
 * 几种模板
 * @author zhaoxu
 * @date 1/9/2023 10:50 AM
 * @since
 */
public class SubArray {


    //第一种,双循环,
    //外层定尾巴
    //内层定头
    private  void printSub1(int[] arr) {
        // 首先粗写双循环,进一步的考虑边界
        // 外层: index = 0 做尾巴没问题,但需要j=i,即单元素数组
        for (int end = 0; end < arr.length; end++) {
            for (int start = 0; start <= end; start++) {
                int[] temp = new int[end-start+1];
                System.arraycopy(arr,start,temp,0,end-start+1);
                PrintUtil.printArr(temp);
            }
        }

    }






    public static void main(String[] args) {
        int[] arr  = new int[]{1,2,3,4};
        SubArray o= new SubArray();
        o.printSub1(arr);
    }
}
