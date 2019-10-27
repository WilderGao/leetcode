package 链表;

/**
 * @author WilderGao
 * time 2019-10-26 18:07
 * motto : everything is no in vain
 * description leetcode 138: 复制带随机指针的链表
 */
public class CopyRandomList {
    public Node solution(Node head) {
        if (head == null) {
            return head;
        }
        Node preNode = head;
        while (preNode != null) {
            Node afterNode = new Node(preNode.val, null, null);
            afterNode.next = preNode.next;
            preNode.next = afterNode;
            preNode = afterNode.next;
        }
        preNode = head;
        while (preNode.next != null && preNode.next.next != null) {
            if (preNode.random != null) {
                preNode.next.random = preNode.random.next;
            }
            preNode = preNode.next.next;
        }
        //拆分成两个链表
        preNode = head;
        Node copyHead = head.next;
        Node copyNode = copyHead;
        while (copyNode != null && copyNode.next != null) {
            preNode.next = copyNode.next;
            copyNode.next = preNode.next.next;
            preNode = preNode.next;
            copyNode = copyNode.next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(5, null, null);
        Node node4 = new Node(6, null, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2.random = node1;
        node3.random = node4;

        Node resultHead = new CopyRandomList().solution(node1);
        System.out.println(resultHead);

    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
