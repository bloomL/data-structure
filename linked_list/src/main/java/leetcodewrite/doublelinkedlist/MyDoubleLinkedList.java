package leetcodewrite.doublelinkedlist;

/**
 * @author : liguo
 * @Description : 双链表
 * @data : 2020/11/23
 */
public class MyDoubleLinkedList {
    int size;
    /**
     * 哨兵节点,用作伪头
     */
    Node head;
    /**
     * 哨兵节点,用作伪尾
     */
    Node tail;

    public static class Node{
        int data;
        /**
         * 指向前一个节点的指针
         */
        Node next;
        /**
         * 指向后一个节点的指针
         */
        Node prev;
        public Node(int data){
            this.data = data;
        }
    }

    public MyDoubleLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        // 判断index 与 size - index的大小
        if (index + 1 < size - index) {
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
        }else {
            temp = tail;
            for (int i = 0; i < size - index; i++) {
                temp = temp.prev;
            }
        }
        return temp.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     * predecessor 前任
     * successor  后任
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if(index < 0) {
            index = 0;
        }
        Node pred,succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        }else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        Node newNode = new Node(val);
        newNode.next = succ;
        newNode.prev = pred;
        succ.prev = newNode;
        pred.next = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        Node pred,succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        }else {
            succ = tail;
            for (int i = 0; i < size - index -1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        pred.next = succ;
        succ.prev = pred;
        size--;
    }

    /**
     * 输出节点值
     */
    public void outPutNode() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            sb.append(temp.next.data).append("->");
            temp = temp.next;
        }
        System.out.println(sb.toString());
    }

}
