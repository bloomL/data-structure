package leetcodewrite.doublepointer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : liguo
 * @Description : 自定义双指针
 * @data : 2020/11/23
 */
public class MyDoublePointer {
    int size;
    /**
     * 哨兵节点,用作伪头
     */
    Node head;

    public MyDoublePointer() {
        size = 0;
        head = new Node(0);
    }

    /**
     * 快慢指针，判断是否有环
     * 时间复杂度：O(N)，其中 N 是链表中的节点数。
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N 轮。
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。
     * @return boolean true 有环 false 无环
     */
    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 快慢指针，入环的第一个节点
     * fast:a + n(b+c) + b
     * slow: a + b
     * fast = 2slow: a + n(b+c) + b = 2(a+b) => (n-1)(b+c)+c = a
     * 所以从相遇点到入环点的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离。
     * 时间复杂度：O(N)，其中 N 为链表中节点的数目。在最初判断快慢指针是否相遇时，slow 指针走过的距离不会超过链表的总长度；
     * 随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为 O(N)+O(N)=O(N)。
     *
     * 空间复杂度：O(1)。我们只使用了slow,fast,ptr 三个指针。
     *
     * @return Node
     */
    public Node detectCycle() {
        if (head == null ) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null){
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return null;
            }
            if (slow == fast) {
                Node temp = head;
                while(temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    /**
     * 相交链表
     * 时间复杂度 : O(m+n)
     * 空间复杂度 : O(1)
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node nodeA = headA,nodeB = headB;
        while(nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * 删除链表的倒数第N个节点(一次遍历)
     * 时间复杂度：O(L)，其中 L 是链表的长度。
     * 空间复杂度：O(1)。
     * @param n 倒数第n节点
     * @return 头结点
     */
    public Node removeNthFromEnd(int n) {
        //哑节点，当first遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点
        Node dummy = new Node(0, head);
        Node first = head;
        Node second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 删除链表的倒数第N个节点(栈实现)
     * 时间复杂度：O(L)，其中 L 是链表的长度。
     * 空间复杂度：O(L)，其中 L 是链表的长度。主要为栈的开销。
     * @param n 倒数第n节点
     * @return 头结点
     */
    public Node removeNthFromEnd2(int n) {
        //哑节点，当first遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点
        Node dummy = new Node(0, head);
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = dummy;
        while(cur != null) {
            // 压入堆栈
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            // 堆栈弹出一个元素。 换句话说，删除并返回此双端队列的第一个元素
            stack.pop();
        }
        // 检索但不删除此双端队列代表的队列的头
        Node peek = stack.peek();
        peek.next = peek.next.next;
        return dummy.next;
    }

    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
