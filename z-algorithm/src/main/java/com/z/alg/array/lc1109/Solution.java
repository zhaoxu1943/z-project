package com.z.alg.array.lc1109;

//这里有 n 个航班，它们分别从 1 到 n 进行编号。
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
//
//
//
// 示例 1：
//
//
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
//
//
// 示例 2：
//
//
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 10⁴
// 1 <= bookings.length <= 2 * 10⁴
// bookings[i].length == 3
// 1 <= firsti <= lasti <= n
// 1 <= seatsi <= 10⁴
//
//
// Related Topics 数组 前缀和 👍 433 👎 0


import com.z.alg.util.PrintUtil;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //处理区段加减
    //i,j 区段变化 Δ  ,差分数组Ci + Δ Cj+1 - Δ
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //对差分数组处理即可
        int[] res = new int[n];
        //填充差分数组
        int[] c_res = new int[n+1];
        c_res[1] = res[0];
        for (int i = 2; i < c_res.length; i++){
            c_res[i] = res[i-1]-res[i-2];
        }
        for (int[] book:  bookings) {
            c_res[book[0]] += book[2];
            //边界外的不处理
            if ((book[1]+1)<c_res.length) {
                c_res[book[1]+1] -= book[2];
            }
        }
        //根据差分数组求解
        res[0] = c_res[1];
        int sum = res[0];
        for (int i = 2; i < c_res.length; i++){
            sum += c_res[i];
            res[i-1] = sum;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] para_1 = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        Solution o = new Solution();
        int[] arr = o.corpFlightBookings(para_1,n);
        PrintUtil.printArr(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
