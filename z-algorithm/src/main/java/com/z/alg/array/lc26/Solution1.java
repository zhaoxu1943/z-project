package com.z.alg.array.lc26;

/**
 * @author zhaoxu
 * @date 11/7/2022 1:22 PM
 * @since
 */
//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致
//。
//
// 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个
//元素应该保存最终结果。
//
// 将最终结果插入 nums 的前 k 个位置后返回 k 。
//
// 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
// 判题标准:
//
// 系统会用下面的代码来测试你的题解:
//
//
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//
// 如果所有断言都通过，那么您的题解将被 通过。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 升序 排列
//
//
// Related Topics 数组 双指针 👍 2917 👎 0

import java.util.Arrays;

/**
 *
 * 升序排列 的数组 nums
 *
 * 原地 删除
 *
 * 不要拘泥于题目中的空间
 * 实现永远是第一步,只要实现,说明想法没问题,可以逐步迭代
 *
 * 在思路:双循环,并缩短数组的情况下,致命问题是:由于数组的不断缩短,导致索引失效
 *
 * 故此路不通,应该利用升序条件
 *
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int removeDuplicates(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]) {

            }

        }







        //思路: for循环*2,双循序寻找重复元素,实际上并没有利用
        // '有序'的条件
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    nums=remove(nums,j);
                }else{
                    //当遇到不同数字,跳出循环
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length;
    }


    /**
     *
     * [1,2,3,4,5]
     * [1,2,4,5]
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public int[] remove(int[] arr,int index) {
        if (arr == null) {
            return null;
        }
        if (index < 0 || index > arr.length - 1) {
            return arr;
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        return Arrays.copyOf(arr,arr.length-1);

    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(nums));
        Solution1 obj = new Solution1();
        int length = obj.removeDuplicates(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }







}

//leetcode submit region end(Prohibit modification and deletion)
