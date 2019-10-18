package 链表;

/**
 * @author WilderGao
 * time 2019-10-16 10:42
 * motto : everything is no in vain
 * description leetcode 86：分隔链表
 */
public class Partition {
    public ListNode solution(ListNode head, int x) {
        //思路就是遍历一遍，把一个链表按照x分隔成两个链表再把它们合起来
        ListNode node = head;
        ListNode lessNodeHead = head;
        ListNode moreNodeHead = head;
        while (node != null) {
            if (node.val < x) {
                lessNodeHead = node;
                break;
            }
            node = node.next;
        }
        node = head;
        while (node != null) {
            if (node.val >= x) {
                moreNodeHead = node;
                break;
            }
            node = node.next;
        }
        //如果相同，证明链表中找不到比x大或者比x小的，直接返回原来链表
        if (lessNodeHead == moreNodeHead){
            return head;
        }
        ListNode lessNode = lessNodeHead;
        ListNode moreNode = moreNodeHead;
        node = head.next;
        while (node != null) {
            if (node.val < x && node != lessNode) {
                lessNode.next = node;
                lessNode = lessNode.next;
            } else if (node.val >= x && node != moreNode) {
                moreNode.next = node;
                moreNode = moreNode.next;
            }
            node = node.next;
        }
        moreNode.next = null;
        lessNode.next = moreNodeHead;
        head = lessNodeHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(2);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        node1.next = node2;
        ListNode result = new Partition().solution(node1, 2);
        System.out.println(result);
    }
}
