package com.z.alg.linkedlist.lc25;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
//
//提示：
//
//
// 链表中的节点数目为 n
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
//
//
//
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
//
//
//
//
// Related Topics 递归 链表 👍 1842 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import cn.hutool.core.lang.Assert;
import com.z.common.base.BaseUtil;
import com.z.common.base.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 *
 *
 *
 * 2022年11月8日 16:54:04 passed
 *
 * 1. use 2 hours passed a hard without help
 * 2. based 已知问题将未知问题分解
 * 3. 所以将该k翻转转换为3个小问题
 *    1. 拆分为k长度的多个数组
 *    2. 对数组翻转
 *    3. merge
 * 并通过单元测试,各个部分排查,最终passed
 * 空间复杂度O(N) 时间复杂度O(N)
 *
 * 遇见的问题
 *    1. 拆分的过程中,每k个截断,需要取余,而不是就判一个k
 *    2. 对长链表翻转要改造为k翻转,不然返回的是最后结点
 *    3.  找尾巴merge即可
 *
 * //TODO 看老师解法
 *
 *
 *
 *
 */
@Slf4j
class Solution {


    //reverse K
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1 拆,每组k个,k<=链表长度

        List<ListNode> heads = new ArrayList<>();
        //
        int p = 0;
        while (head!=null) {
            if (p%k==0) {
                heads.add(head);
            }
            p++;
            head = head.next;
        }


        //standard  reverse: convert to known problem!
        //局部翻转
        List<ListNode> reversedHeads= new ArrayList<>();

        for (int i = 0; i < heads.size()-1; i++) {
            head =  reverseListK(heads.get(i),k);
            reversedHeads.add(head);
        }

        if (p%k!=0){
            reversedHeads.add(heads.get(heads.size()-1));
        }else{
            reversedHeads.add(reverseListK(heads.get(heads.size()-1),k));
        }

        //合并! merge

        return merge(reversedHeads,k);

    }





    public ListNode reverseListK(ListNode head, int k) {
        //double pointer
        ListNode slow = null;
        ListNode fast = head;
        int p = 0;
        while(fast!=null&&p<k) {
            //save
            ListNode temp = fast.next;
            //reverse,改边
            fast.next = slow;
            //go ahead,后移一位的基本操作
            slow = fast;
            fast = temp;
            p++;
        }
        //终局 fast == null,终止,此时fast =null, so return slow!
        return slow;
    }


    public ListNode merge(List<ListNode> reversedHeads, int k) {


        for (int i = 0; i < reversedHeads.size()-1; i++) {
            ListNode tail =  getTailByHead(reversedHeads.get(i),k);
            tail.next = reversedHeads.get(i+1);
        }
        return reversedHeads.get(0);

    }


    /**
     * 链表:先操作,后前进,你前进到null末尾了还操作个啥
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public ListNode getTailByHead(ListNode head, int k ) {
        ListNode result = null;
        int p= 1;
        while (head != null) {

            if (p==k){
                result = head;
            }
            p++;
            head = head.next;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        //单元测试: get tail 函数
        log.info("getTail函数单元测试----start---");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Assert.isTrue(3==obj.getTailByHead(head,3).val);
        log.info("getTail函数单元测试----stop---");


        //单元测试:merge 函数
        log.info("merge函数单元测试----start---");
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(1);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(3);

        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head1);
        nodeList.add(head2);

        ListNode headmerge = obj.merge(nodeList,2);

        BaseUtil.printBaseLinkedList(headmerge);
        log.info("merge函数单元测试----stop---");




        log.info("reverseListK 单元测试 --start");
        log.info("部分翻转,翻到第k个位置,比如1->2->3->4->5->null,进行k=2翻转后,结果是 2->1,返回节点2");
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);
        head6.next.next.next = new ListNode(4);
        head6.next.next.next.next = new ListNode(5);
        int k6 = 2;
        ListNode reverseListKNode  = obj.reverseListK(head6,k6);
        BaseUtil.printBaseLinkedList(reverseListKNode);

        log.info("reverseListK 单元测试 --stop");



        log.info("集成测试 --start");
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(4);
        head5.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode headreverseK  = obj.reverseKGroup(head5,k);

        BaseUtil.printBaseLinkedList(headreverseK);

        log.info("集成测试 --stop");





    }
}
//leetcode submit region end(Prohibit modification and deletion)
