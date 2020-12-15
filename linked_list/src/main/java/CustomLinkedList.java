import java.util.HashMap;
import java.util.Map;

/**
 * @author : liguo
 * @Description : 自定义链表（线性表）
 * @data : 2020/11/17
 */
public class CustomLinkedList<E> {
    private Node head = new Node();

    /**
     * 添加节点
     * @param e 节点值
     */
    public void addNode(E e) {
        Node newNode = new Node(e);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertNode(int index, E e) {
        if (index < 1 || index > length()) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
    }

    /**
     * 链表长度
     * @return int
     */
    public int length() {
        int length = 0;
        Node temp = head;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
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





    public class Node {
        /**
         * 数据域
         */
        public E data;
        /**
         * 指针域，指向下一节点
         */
        public Node next;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
