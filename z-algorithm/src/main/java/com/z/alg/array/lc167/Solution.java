package com.z.alg.array.lc167;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        //固定一端,比如固定i,则是保留i的遍历
        // numbers.length-1为最大索引,而i作为较小的一端,应该小于该最大索引
        for (int i = 0; i < numbers.length-1; i++) {
            int j = numbers.length-1;
            //for i 则是固定i
            while (i<j&& numbers[i]+numbers[j]>target){
                j--;
            }
            if (i<j&& numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
        }
        return new int[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)