package com.z.alg.linkedlist.lc141;

//给你一个链表的头节点 head ，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 10⁴]
// -10⁵ <= Node.val <= 10⁵
// pos 为 -1 或者链表中的一个 有效索引 。
//
//
//
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
//
// Related Topics 哈希表 链表 双指针 👍 1674 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.z.common.base.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        //guard ,single node
        if (head.next==null) {
            return false;
        }

        //if life is a circle
        //we will meet again
        ListNode slow = head;
        ListNode fast = head;

        while (slow!=null&&fast!=null) {
            //step 1
            slow=slow.next;
            //step 2
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }

            if (slow==fast) {
                return true;
            }

        }
        return false;

    }




    /**
     * teacher version
     *
     * more fluent
     *
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    public boolean hasCycle2(ListNode head) {
        // no more step  by step
        // limit in while conditon

        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //so can step 2
            head = head.next;
            fast = fast.next.next;
            //if they meet
            if (head==fast){
                return true;
            }
        }
        return false;

    }




    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 =  new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Solution solution  = new Solution();

        System.out.println(solution.hasCycle(head));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
