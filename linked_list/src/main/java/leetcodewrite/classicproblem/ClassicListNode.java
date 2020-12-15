package leetcodewrite.classicproblem;

/**
 * @author : liguo
 * @Description : 经典问题用的链表
 * @data : 2020/11/25
 */
public class ClassicListNode {

    Node head;

    public ClassicListNode() {
        head = new Node(0);
    }


    /**
     * 反转链表
     * 时间复杂度：O(L)，其中 L 是链表的长度。
     * 空间复杂度：O(1)。
     * @param head 头结点
     * @return 反转后链表
     */
    public Node reverseList(Node head) {
        Node pre = null;
        Node cur = head;
        while(cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * 哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，它们是纯功能的，通常不保存任何数据，
     * 其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
     * 时间复杂度：O(N)，只遍历了一次。
     * 空间复杂度：O(1)。
     *
     * @param head 头结点
     * @param val 定值
     * @return 删除后链表
     */
    public Node removeElements(Node head, int val) {
        Node sentinel = new Node(0);
        sentinel.next = head;
        Node pre = sentinel;
        Node cur = head;
        while(cur != null) {
            if (cur.data == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return  sentinel.next;
    }


    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
