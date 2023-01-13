package com.z.alg.array.lc53;

/**
 * @author zhaoxu
 * @date 1/12/2023 4:49 PM
 * @since
 */
public class Solution {

    /**
     * 同样是
     * 连续子数组的问题:
     * so: 前缀和
     * 最基础的行为,肯定是借助连续子数组双循环(n^3)
     * 借助前缀和数组统计
     *
     * 果然直接进行一个超时
     * 下一步开始 进一步的优化
     * 目前的时间复杂度,借助前缀和为O(n^2
     * )
     *
     * //            A [-2,1,-3,4,-1,2,1,-5,4]
     * //            S [-2,-1,-4,0,-1,1,2,-3,1]
     * //
     * //        A_MAX [-2,1,1,4,4,4,4,4,4]
     * //        S_MAX [-2,-1,-1,0,0,1,2,2,2]
     * //
     * //        A 1
     * //        s 1
     * //        a_max 1
     * //        s_max 1
     * //        1
     * //
     * //
     * //        A [5,4,-1,7,8]
     * //        S [5,9,8,15,23]
     * //        A_MAX [5,5,5,7,8]
     * //        S_MAX [5,9,9,15,23]
     * //
     *
     * 通过前缀和寻找规律:
     * 从双循环开始我们通过前缀和数组,通过更新int res,来逐渐的获取最大子段和:
     * 但需要O(n^2)的时间复杂度
     *
     * 重新审视条件后
     * sum[l,r] = sum[l] - sum[r-1]
     * 令 i= l ,j = r-l
     * 公式转换为 sum[i]-sum[j]
     * 那么在固定外层循环i,也是end的情况下,求最小的sum[j]即可
     * 如何在O(1)时间内无需循环 ,获取sum[j] : 前缀最小值!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     *
     * @author zhaoxu
     */
    public int maxSubArray(int[] nums) {
        int res= -10000;
        //1. 求前缀和数组
        int[] sumArr = new int[nums.length+1];
        int sum = 0;
        for (int i = 1; i < sumArr.length ; i++) {
            sum += nums[i-1];
            sumArr[i] = sum;
        }
        //2. 初始化前缀最小值为 sumArr[0]
        int min_sumArr =  sumArr[0];
        for (int i = 1; i <  sumArr.length; i++) {
                //维护前缀最小值
                //该取哪一位的最小值?
            min_sumArr = Math.min(min_sumArr,sumArr[i-1]);
            int temp = sumArr[i] - min_sumArr;
                if (temp>res) {
                    res =temp;
                }
        }
        return  res;
    }


    public static void main(String[] args) {
        int[] par_1  = new int[]{-1};
        Solution o = new Solution();
        int res = o.maxSubArray(par_1);
        System.out.println(res);
    }


}
