package 链表;

/**
 * @author WilderGao
 * time 2019-10-10 09:59
 * motto : everything is no in vain
 * description leetcode 24:两两交换链表中的节点
 */
public class SwapPairs {
    /**
     * 自己做的，可能会有毒
     * @param head 链表头节点
     * @return  反转后的链表
     */
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = head.next;
        ListNode preTail = head;
        ListNode beforeReverse = head;
        ListNode node = head.next;
        ListNode nodeAfter = node.next;
        //反转一次
        beforeReverse.next = null;
        node.next = beforeReverse;
        beforeReverse = node;
        node = nodeAfter;
        nodeAfter = nodeAfter.next;
        while (nodeAfter != null) {
            beforeReverse = node;
            node = node.next;
            nodeAfter = nodeAfter.next;

            beforeReverse.next = null;
            node.next = beforeReverse;
            preTail.next = node;
            preTail = beforeReverse;

            beforeReverse = node;
            node = nodeAfter;
            if (nodeAfter != null) {
                nodeAfter = nodeAfter.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = new SwapPairs().solution(node1);
        System.out.println(node);
    }
}
