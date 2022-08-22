package linkedlist.base;

/**
 * 双链表节点
 * @author zhaoxu
 * @date 2022/8/22 16:45
 * @since
 */
public class DoubleLinkedListNode<T> {

    private DoubleLinkedListNode prev;

    private DoubleLinkedListNode next;

    private T o;

    public DoubleLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    public T getO() {
        return o;
    }

    public void setO(T o) {
        this.o = o;
    }
}
