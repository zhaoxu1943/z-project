package com.z.alg.array.lc26;

/**
 * @author zhaoxu
 * @date 11/8/2022 11:29 AM
 * @since
 */
public class Solution3_right {

    class Solution {
        //do not need exchange
        // just cover!
        //即升序相邻双指针!
        public int removeDuplicates(int[] nums) {

            int slow = 0,fast = 1;
            while(fast<nums.length){
                if (nums[slow]==nums[fast]){
                    fast++;
                }else{
                    nums[++slow]=nums[fast++];
                }
            }
            return slow+1;

        }
    }
}
