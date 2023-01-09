package com.z.alg.array.lc1248;

/**
 * lc1248 : 优美子数组问题
 *
 * @author zhaoxu
 * @date 12/26/2022 1:34 PM
 * @since
 */
public class YouMei {

    /**
     * 遍历子数组的标准写法
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */



    /**
     * 限时15分钟解决优美,ON
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        // 转换为odd 数组, 索引从1 开始
        int[] oddArr = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            oddArr[i] = nums[i-1] &1;
        }

        // count[1,1,2,1,1,0]
        // 求前缀和数组s
        int[] s = new int[nums.length+1];
        s[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            s[i] =  s[i-1]+oddArr[i];
        }

        // 最后直接求值
        // 此时的边界条件如何考虑??

        // 首先我的count 数组是从index0开始,此时的边界条件很难考虑啊
        // 正常来说,遍历 前缀和数组应该是
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i ; j++) {

                if (s[i]-s[j-1]==k) {
                    res++;
                }
            }

        }
        return  res;

    }


    /**
     * 优化版本
     * 仔细观察上文的双循环:
     *
     *     for (int i = 1; i <= nums.length; i++) {
     *             for (int j = 1; j <= i ; j++) {
     *
     *                 if (s[i]-s[j-1]==k) {
     *                     res++;
     *                 }
     *             }
     *
     * 当j = 0 ;j<=i-1时
     * 公式变为  s[i] - s[j] == k
     * 进一步的,忽略取值之后,问题变为了类似两数之和的两数之差
     * 即,在count数组中,有多少种情况,使两数之差等于k?
     * s[i] 为一个两数之差,而s[j] 同样为一个两数之差
     * s[j] = s[i] -k
     *
     * 将循环 变为统计,统计有多少个这样的S[j] 满足s[i]-k
     * 用什么统计?
     * count数组
     *
     * 所以核心就是求出count数组
     *
     *
     *
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        int res = 0;
        // 转换为odd 数组, 索引从1 开始
        int[] oddArr = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            oddArr[i] = nums[i-1] &1;
        }
        //转化后计数
        //原理: 双循环演进:
        //1. for i=1~n
        //    for  j= 1~i
        // 根据前n项和公式,只要满足 前N项和数组S,满足
        // S(j,i) =  S[i] - S[j-1] ==k ,即可
        //  但双循环时间复杂度为O(N^2)
        // 利用公式进一步降低时间复杂度
        // 即 固定外层循环法: 固定外层 for i = 1~n的循环
        //从公式中 进一步转换为 s[j-1] = s[i]-k
        //我们通过计数的方法,来计算即可,转换为 前N项和s数组的count数组
        // 所以第二补,我们来求count数组

        // 仍然开一个 length +1 的长度,S数组第一项为0,所以 0有一个
        // 举例 [1,1,2,1,1]
        // odd [1,1,0,1,1]
        // s [0,1,2,2,3,4]

        // count[1,1,2,1,1,0]
        // 求前缀和数组s
        int[] s = new int[nums.length+1];
        s[0] = 0;
        int[] count = new  int[nums.length+1];
        count[0]=1;
        for (int i = 1; i <= nums.length; i++) {
            s[i] =  s[i-1]+oddArr[i];
            count[s[i]]++;
            if (s[i]-k>=0){
                res += count[s[i]-k];

            }
        }

        return res;




    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,1,1};
        int k  =  3;

        YouMei o = new YouMei();
        int res =  o.numberOfSubarrays1(arr,k);
        System.out.println(res);
    }

}
