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


    //region lc1248:优美子数组
    public int numberOfSubarrays(int[] nums, int k) {

        //<editor-fold desc="转换为奇偶数组">
            int[] oddArr = new int[nums.length+1];
                oddArr[0]=0;
                for (int i = 1; i <= nums.length; i++) {
                    oddArr[i] = nums[i-1] & 1;
            }
        //</editor-fold>

        // 进一步的,对奇数数组进行处理










            }
    //endregion


}
