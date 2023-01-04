package com.z.alg.array.lc1248;

import java.util.HashMap;
import java.util.Map;

/**
 * lc1248 : 优美子数组问题
 *
 * @author zhaoxu
 * @date 12/26/2022 1:34 PM
 * @since
 */
public class YouMei {



        public int numberOfSubarrays(int[] nums, int k) {
            int res  = 0;
            //1. convert to 0,1 arr
            int[] oddArr  = convertArr(nums);
            //将计算改为查hash
            Map<Integer, Integer> sumMap = new HashMap<>();
            sumMap.put(0,0);
            //fill sum array,  from 1 to nums.length
            for (int i = 1; i <= nums.length; i++) {
                int temp = 0;
                for (int j = 0; j <= i-1; j++) {
                    temp += oddArr[j];
                }
                sumMap.put(i,temp);
            }

            //2. lianxu ziji,计算j-i
            //继续转化: ,目前是双循环,通过i的递增,子数组窗口逐渐变大
            //而第二层的遍历实际上可以转换
            // sum[i] - sum[j-1] == k
            //相当于 sum[j-1] = sum[i] - k
            // sum[j] = sum[i] - k

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= i; j++) {
                    if(sumMap.get(i)-sumMap.get(j-1)==k){
                        res = res + 1;
                    }
                }
            }
            return res;
        }


    private int[] convertArr(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i]&1;
        }
        return res;
    }

    /*
    举例来说,什么叫前缀和和前缀和的个数
       A = [1,1,1,2,1]
       S = [1,2,3,4,5]

       而转化数组:
       A_odd = [1,1,1,0,1]
       S_odd = [1,2,3,3,4]

       而prefixcont 则下标是前缀和
       pre[0] = 1;
       而 1 1
       2 1
       3 2
       4 1
       5 0
    */


    public int numberOfSubarrays1(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        //init
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        //这样遍历相当于从1开始,不再考虑0,不再考虑索引
        for (int num: nums) {
            // 如果有奇数,sum计数+1




            sum += num & 1;
            //对应的,计数数组
            prefixCnt[sum]++;
            //
            // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
            // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
            //// 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
            // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
            //@starrysky 这里的前缀和指的是从0开始到当前元素这个区间的奇数的个数，
            // 所以两个前缀和的差就是两个元素之间的奇数的个数，
            // 我们要找的就是奇数个数为k的区间哈。
            // prefixCnt数组是用来统计的是前缀和的个数，
            // 数组下标是前缀和，
            // 值是个数。
            // 如果当的前缀数组的奇数个数为s2，那我们需要看有多少个前缀数组的奇数个数为 s1 = s2 - k 的，那么这些区间的奇数个数都是k，就累加到res中哈。
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }




    public static void main(String[] args) {
        YouMei obj = new YouMei();
        int[] var1 = new int[]{1,1,1,2,1};
        int var2 = 1;
        int res = obj.numberOfSubarrays1(var1,var2);
        System.out.println(res);

    }

    /**
     *
     * lc写法:
     * 首先明确再求出前缀和数组之后:双循环判定 sum[i]- sum[j-1] == k, res++; 将超时
     * @author zhaoxu
     */
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
            //init
            int[] prefixCnt = new int[nums.length + 1];
            prefixCnt[0] = 1;
            // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
            // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
            int res = 0, sum = 0;
            for (int num: nums) {
                sum += num & 1;
                prefixCnt[sum]++;
                if (sum >= k) {
                    res += prefixCnt[sum - k];
                }
            }
            return res;
        }
    }



}
