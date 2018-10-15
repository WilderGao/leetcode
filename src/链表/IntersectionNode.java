package 链表;

/**
 * @author WilderGao
 * time 2018-10-15 17:51
 * motto : everything is no in vain
 * description 相交链表，如果链表相交找出交点
 */
public class IntersectionNode {
    /**
     * 把无环的链表当作有环来进行处理
     * @param headA 链表A
     * @param headB 链表B
     * @return  相交的节点
     */
    public ListNode solutionOne(ListNode headA, ListNode headB) {
        if (headA == null || headA == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }


    /**
     * 先求出两个链表的长度，然后让长的链表先遍历直到两者在同一起跑线，同时开始遍历，当有相同的节点时表示链表有相交
     * @param headA 链表A
     * @param headB 链表B
     * @return  相交的节点
     */
    public ListNode solutionTwo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        int lengthA = 1, lengthB = 1;

        //求出链表A和B的长度
        while (a != null || b != null) {
            if (a != null) {
                lengthA++;
                a = a.next;
            }
            if (b != null) {
                lengthB++;
                b = b.next;
            }
        }
        a = headA;
        b = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null && a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
