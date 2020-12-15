package leetcodewrite.linkedlist;

/**
 * @author : liguo
 * @Description : 单链表
 * @data : 2020/11/18
 */
 public class MyLinkedList {
    /**
     * 链表大小
     */
    int size;
    /**
     * 哨兵节点,用作伪头、伪尾等，纯功能的，通常不保存任何数据，
     * 其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除
     */
    Node head;

    /** 节点定义 */
    private static class Node {
        int val;
        Node next;
        public Node(int x){
            this.val = x;
        }
    }

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            head = new Node(0);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0 || index >= size) {
                return -1;
            }
            Node temp = head;
            for (int i = 0; i < index +1; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if(index < 0) {
                index = 0;
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) {
                return;
            }
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }

    /**
     * 输出节点值
     */
    public void outPutNode() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            sb.append(temp.next.val).append("->");
            temp = temp.next;
        }
        System.out.println(sb.toString());
    }
}
