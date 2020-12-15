import leetcodewrite.doublelinkedlist.MyDoubleLinkedList;
import leetcodewrite.linkedlist.MyLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : liguo
 * @Description : 类描述
 * @data : 2020/11/17
 */
@SpringBootTest(classes = {CustomLinkedList.class})
public class LinkListDemoTest {

    @Test
    public void testAdd(){
        CustomLinkedList custom = new CustomLinkedList();
        custom.addNode(1);
        custom.addNode(2);
        System.out.println("链表长度："+ custom.length());
        custom.outPutNode();
    }

    /**
     * 测试MyLinkedList
     * [\,"deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [\,[2],[6],[4],[4],[4],[5,0],[6]]
     */
    @Test
    public void testMyLinkedList(){
        MyLinkedList my = new MyLinkedList();
        my.addAtHead(7);
        my.outPutNode();
        my.addAtHead(2);
        my.outPutNode();
        my.addAtHead(1);
        my.outPutNode();
        my.addAtIndex(3,0);
        my.outPutNode();
        my.deleteAtIndex(2);
        my.outPutNode();
        my.addAtHead(6);
        my.outPutNode();
        my.addAtTail(4);
        my.outPutNode();
        System.out.println(my.get(4));
        my.addAtHead(4);
        my.addAtIndex(5,0);
        my.addAtHead(6);
    }

    @Test
    public void testMyDoubleLinkedList(){
        MyDoubleLinkedList my = new MyDoubleLinkedList();
        my.addAtHead(7);
        my.outPutNode();
        my.addAtHead(2);
        my.outPutNode();
        my.addAtHead(1);
        my.outPutNode();
        my.addAtIndex(3,0);
        my.outPutNode();
        my.deleteAtIndex(2);
        my.outPutNode();
        my.addAtHead(6);
        my.outPutNode();
        my.addAtTail(4);
        my.outPutNode();
        System.out.println(my.get(4));
        my.addAtHead(4);
        my.addAtIndex(5,0);
        my.addAtHead(6);
    }

}
