package com.z.common.base;



/**
 * @author zhaoxu
 * @date 11/8/2022 4:20 PM
 * @since
 */

public class BaseUtil {


    public static void printBaseLinkedList(ListNode head) {
        if (head==null){
            System.out.println("链表为空!");
        }
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
