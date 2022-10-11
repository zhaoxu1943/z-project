package com.z.alg.tree;


import com.z.common.base.TreeNode;

/**
 * @author zhaoxu
 * @date 2022/10/11 16:38
 * @since
 */
public class BinaryTreeDepth {

    //init
    private int depth = 0;

    /**
     * 树离不开递归
     *
     * 递归要素,
     *
     * 临界条件终止递归
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    private  int getDepth(TreeNode node) {
        //grand
        if (node==null){
            return depth;
        }
        //临界条件
        if (node.getLeft()==null&&node.getRight() == null) {
            return depth;
        }else {
            depth++;
            return Math.max(getDepth(node.getLeft()),getDepth(node.getRight()));
        }

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
        TreeNode root = new TreeNode(1);
        //layer_1
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(321));
        //l2
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(33));
        //l3
        root.getRight().setRight(new TreeNode(2213));

        //l4
        root.getRight().getRight().setLeft(new TreeNode(6589));


        BinaryTreeDepth obj = new BinaryTreeDepth();

        System.out.println(obj.getDepth(root));

    }

}
