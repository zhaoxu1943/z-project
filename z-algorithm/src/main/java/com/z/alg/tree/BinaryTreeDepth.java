package com.z.alg.tree;


import com.z.common.base.TreeNode;

/**
 * @author zhaoxu
 * @date 2022/10/11 16:38
 * @since
 */
public class BinaryTreeDepth {



    /**
     * 树离不开递归
     *
     * 递归三大要素:
     *
     * 终止条件:节点为空
     * 执行过程: 很多情况下就是一个+1,或者比如mergeSort中的merge操作
     * 返回值: 每层+1
     * 递归发生点:左右子树
     *
     *
     * 临界条件终止递归
     *
     * 问题在于
     * 不应该在节点处加
     * 应该在层次加
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */

    public int maxDepth(TreeNode root) {
        //grand ,null, 0层
        if (root==null){
            return 0;
        }
        //向下探测
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }


    /**
     * test
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public static void main(String[] args) {
        //init binary tree
        //layer_1
        TreeNode root = new TreeNode(3);
        //layer_2
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        //layer_3
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        BinaryTreeDepth obj = new BinaryTreeDepth();
        System.out.println(obj.maxDepth(root));

    }

}
