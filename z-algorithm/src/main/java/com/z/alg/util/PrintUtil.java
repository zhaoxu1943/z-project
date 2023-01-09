package com.z.alg.util;

public class PrintUtil {


    public static void printArr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("arr:[");
        for (int i : arr) {
         sb.append(i);
         sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        printArr(arr);
    }

}
