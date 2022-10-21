package com.z.alg.sort.merge;

/**
 * @author zhaoxu
 * @date 2022/10/20 10:12
 * @since
 */
public class Merge {


    /**
     * merge: my version
     *
     *  for 循环,但循环自变量在外
     *  写起来奇怪,故使用while循环
     *
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int size = m+n;
        int[] result = new int[size];
        int i = 0;
        int j = 0;
        for(;index<size;index++) {
            //process oob
            if( i==m || j==n){
                break;
            }

            if(nums1[i]<=nums2[j]) {
                result[index] = nums1[i];
                i++;
            }else{
                result[index] = nums2[j];
                j++;
            }
        }

        //剩余填充
        while(index<size) {

            if(i==m){
                //nums2没拷贝完
                for(;index<size;index++){
                    result[index] = nums2[j];
                    j++;
                }
            }else{
                //nums1没拷贝完
                for(;index<size;index++){
                    result[index] = nums1[i];
                    i++;
                }
            }
        }
        //最后拷贝
        for(int k=0;k<size;k++) {
            nums1[k] = result[k];
        }
    }



    /**
     * merge: my version
     *
     * use while instead
     *
     * 牛的兄弟,两次通过!
     * 第一次没通过原因:
     * 还是端点,while因何循环?未到索引越界所以循环
     *
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * 均遍历+拷贝一遍即可
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public void merge_while_version(int[] nums1, int m, int[] nums2, int n) {
        //init part
        int indexInTempArray = 0;
        int indexInNums1 = 0;
        int indexInNums2 = 0;
        int size = m+n;
        int[] tempArray = new int[size];


        //用while想清楚循环终止条件,也就是下标越界!
        //逐步递增,所以不会同时越界
        //只要有一个越界
        while (indexInNums1<=m||indexInNums2<=n) {
            //处理越界事件
            if (indexInNums1==m) {
                //nums1 遍历完了,拷贝nums2即可
                while (indexInTempArray<size){
                    tempArray[indexInTempArray++] = nums2[indexInNums2++];
                }
                break;
            }

            if (indexInNums2==n) {
                while (indexInTempArray<size){
                    tempArray[indexInTempArray++] = nums1[indexInNums1++];
                }
                break;
            }
            //处理正常循环
            if (nums1[indexInNums1]<=nums2[indexInNums2]){
                tempArray[indexInTempArray++]=nums1[indexInNums1++];
            }else{
                tempArray[indexInTempArray++]=nums2[indexInNums2++];
            }

        }

        //最后拷贝
        for(int k=0;k<size;k++) {
            nums1[k] = tempArray[k];
        }
    }


    /**
     * 挑战back!
     * 什么是最优解法,能利用题目所有元素
     *
     * 包括但不限于:
     * 有序
     * 申请好了位置,如num1[]后面的空位...
     *
     *
     * 倒排
     *
     * 从大到小的填,就是从大到小的while
     *
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public void merge_back(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p0 = m+n-1;
        while (p0>=0){
            //p1走完了
            if (p1 < 0&&p2>=0) {
                nums1[p0--]=nums2[p2--];
            }else if (p2 < 0&&p1>=0) {
                nums1[p0--]=nums1[p1--];
            }else if (p1>=0&& p2>=0) {
                //都没走完
                if (nums1[p1]>=nums2[p2]){
                    nums1[p0--]=nums1[p1--];
                }else{
                    nums1[p0--]=nums2[p2--];
                }
            }

        }


    }


    /**
     * 官方倒排
     * 写的真他妈的好
     *
     * 和我的相比,有这些优势:
     * 1. 没有if套if,但精确的讨论了所有可能情况
     * 用cur 替代数组下标访问,更简洁
     * 牛的
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public void merge_back_lc(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }





    /**
     * 官方正牌
     *
     * 官方的看着哥们结冰了
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public void merge_version_lc(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }








}
