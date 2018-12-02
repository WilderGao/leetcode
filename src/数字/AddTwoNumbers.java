package 数字;

/**
 * @author WilderGao
 * time 2018-12-02 10:29
 * motto : everything is no in vain
 * description leetcode 2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            int tag = 0;
            int num = 0;
            ListNode result = new ListNode(num);
            ListNode point = result;
            while (l1 != null && l2 != null) {
                num = l1.val + l2.val + tag;
                point.next = new ListNode(num % 10);
                point = point.next;
                tag = num / 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                num = l1.val + tag;
                point.next = new ListNode(num % 10);
                point = point.next;
                tag = num / 10;
                l1 = l1.next;
            }

            while (l2 != null) {
                num = l2.val + tag;
                point.next = new ListNode(num % 10);
                point = point.next;
                tag = num / 10;
                l2 = l2.next;
            }
            if (tag == 1) {
                point.next = new ListNode(tag);
            }
            return result.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        ListNode result = new AddTwoNumbers().solution(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
