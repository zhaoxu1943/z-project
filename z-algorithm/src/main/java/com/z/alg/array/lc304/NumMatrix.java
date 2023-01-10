package com.z.alg.array.lc304;

/**
 * @author zhaoxu
 * @date 1/10/2023 11:09 AM
 * @since
 */
//给定一个二维矩阵 matrix，以下类型的多个请求：
//
//
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
//
//
// 实现 NumMatrix 类：
//
//
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。
//
//
//
//
// 示例 1：
//
//
//
//
//输入:
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出:
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
//
// -10⁵ <= matrix[i][j] <= 10⁵
// 0 <= row1 <= row2 < m
// 0 <= col1 <= col2 < n
//
// 最多调用 10⁴ 次 sumRegion 方法
//
//
// Related Topics 设计 数组 矩阵 前缀和 👍 453 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class NumMatrix {

    private static int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    /** 0        i
     *0 ♢♢♢♢♢
     *  ♢▷♢♢♢
     *  ♢♢♢♢♢
     *j ♢♢♢♢▷
     *
     * 采用二维数组,矩阵前缀和公式来解决,第一步,生成矩阵前缀和
     *
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int all = getSumFrom00to(row2,col2);
        int left = getSumFrom00to(row2,col1-1);
        int top = getSumFrom00to(row1-1,col2);
        int mid = getSumFrom00to(row1-1,col1-1);
        return all - left-top +mid;
    }






    /**
     * i: row
     * j :col
     * 进一步优化,由于每次需要重复计算
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public int getSumFrom00to(int rowIndex,int colIndex) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sumMatrix =  new int[m+1][n+1];
        //fill
        for (int i = 0; i < m; i++) {
            int[] tempArr = matrix[i];
            int tempSum = 0;
            for (int j = 0; j <= colIndex; j++) {
                tempSum =tempSum + tempArr[j];
            }
            sum += tempSum;
        }
        return sum;
    }







}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
