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
        ListNode pNode = head;
        ListNode pPrev = null, pAfter;
        if (pNode.next == null) {
            return pNode;
        } else {
            pAfter = pNode.next;
            while (pNode != null) {
                pNode.next = pPrev;
                pPrev = pNode;
                pNode = pAfter;
                if (pAfter != null) {
                    pAfter = pAfter.next;
                }
            }
        }
        return pPrev;
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
