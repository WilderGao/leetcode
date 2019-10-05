package 链表;


/**
 * @author WilderGao
 * time 2019-02-12 21:14
 * motto : everything is no in vain
 * description leetcode 206 链表反转
 */
public class ReverseList {
    private ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode before, after;
        if (head.next == null) {
            return node;
        } else {
            before = node;
            node = node.next;
            before.next = null;
            while (node != null) {
                after = node.next;
                node.next = before;
                before = node;
                node = after;
            }
        }
        return before;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        ListNode result = new ReverseList().solution(node1);
        System.out.println(result);
    }
}
