package com.z.alg.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(32332,5434,24,32,4,434,234,24,23,423,342);
        List<Integer> sortedList = mergeSort(numList);
        System.out.println(sortedList);
    }



    public static List<Integer> mergeSort(List<Integer> numList) {
        List<Integer> sortedList = new ArrayList<>();
        if (numList.size()>1) {
            int mid = numList.size()/2;
            List<Integer> leftArr = new ArrayList<>(numList.subList(0,mid));
            List<Integer> rightArr = new ArrayList<>(numList.subList(mid,numList.size()));
            List<Integer> sortedLeftArr = mergeSort(leftArr);
            List<Integer> sortedRightArr = mergeSort(rightArr);
            if (sortedLeftArr.get(0)<sortedRightArr.get(0)){
                sortedList.addAll(sortedLeftArr);
                sortedList.addAll(sortedRightArr);
            }else {
                sortedList.addAll(sortedRightArr);
                sortedList.addAll(sortedLeftArr);
            }

            return sortedList;
        }
        return numList;



    }
}
