package com.z.algtemplate.array;

import com.z.alg.util.PrintUtil;

/**
 * @author zhaoxu
 * @date 1/9/2023 4:31 PM
 * @since
 */
public class IT_ma {

    private static void it_ma(int[][] matrix) {
        for (int[] row : matrix) {
            PrintUtil.printArr(row);
        }
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        it_ma(matrix);

    }



}
