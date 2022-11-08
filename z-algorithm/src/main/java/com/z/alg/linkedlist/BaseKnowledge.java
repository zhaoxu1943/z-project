package com.z.alg.linkedlist;

/**
 *  core point:
 * 1. 单链表:建立头保护节点 must check node null! so add PROTECTED node,maybe zero 0 node
 * 2. 双链表:建立头尾保护节点
 *
 *
 * 避免访问null节点
 * 2. nodeA -> nodeB -------------> nodeC -> null
 *
 *  new NodeD
 *  insert nodeD after nodeB
 *
 *  insert O(1)
 *  1. nodeD.next = nodeB.next;
 *  2. nodeB.next= nodeD;
 *
 *  nodeA -> nodeB -------------> nodeC -> null
 * delete O(1)
 * delete nodeB
 * nodeA.next = nodeB.next;
 *
 * 遍历O(n)
 *
 * 双链表,添加prev节点
 *
 *
 *
 *
 *
 * @author zhaoxu
 * @date 11/8/2022 1:41 PM
 * @since
 */
public interface BaseKnowledge {
}
