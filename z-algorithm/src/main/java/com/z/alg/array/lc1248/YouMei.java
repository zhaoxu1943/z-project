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
            //fill sum array
            for (int i = 1; i <= nums.length; i++) {
                int temp = 0;
                for (int j = 0; j <= i-1; j++) {
                    temp += oddArr[j];
                }
                sumMap.put(i,temp);
            }

            //2. lianxu ziji,计算j-i
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




    public static void main(String[] args) {
        YouMei obj = new YouMei();
        int[] var1 = new int[]{1,1,1,1,1};
        int var2 = 1;
        int res = obj.numberOfSubarrays(var1,var2);
        System.out.println(res);

    }


}
