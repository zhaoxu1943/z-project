package com.z.alg.linkedlist.lc206;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
// Related Topics 递归 链表 👍 2836 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.z.common.base.ListNode;

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
 * save ->reverse->go ahead!
 *
 * 看改几条边?
 * reverse 要改n条边,而不是n-1条
 *
 * 1-->2-->3-->4-->5-->null
 *
 * 老师思路:
 * 1 . 明确改几条边? 5条
 * 2. 咋改, next 改为last
 * 3. last没有!
 * 4. 创造last,解决问题
 * we need prev pointer;
 * so wo create it
 *
 *
 *
 * 访问链表的模板:
 * while(head!=null) {
 * head = head.next;
 * }
 *
 * 如果while中使用 head.next!=null
 * 少了最后的节点,访问了n-1个节点
 *
 */
class Solution {
    //use head, please reverse the linkedlist
    public ListNode reverseList(ListNode head) {
        //double pointer
        ListNode slow = null;
        ListNode fast = head;
        while(fast!=null) {
            //save
            ListNode temp = fast.next;
            //reverse,改边
            fast.next = slow;
            //go ahead,后移一位的基本操作
            slow = fast;
            fast = temp;
        }
        //终局 fast == null,终止,此时fast =null, so return slow!
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
