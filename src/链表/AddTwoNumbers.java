package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-14 15:59
 * motto : everything is no in vain
 * description leetcode 445：两数相加II
 */
public class AddTwoNumbers {
    /**
     * 如果不修改原来链表，那我考虑用两个栈来解决问题
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode node = l1;
        while (node != null) {
            stack1.add(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            stack2.add(node.val);
            node = node.next;
        }
        int up = 0;
        List<Integer> resultList = new ArrayList<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int left = stack1.pop();
            int right = stack2.pop();
            int resultIndex = (left + right + up) % 10;
            up = (left + right + up) / 10;
            resultList.add(resultIndex);
        }

        while (!stack1.isEmpty()) {
            int num = stack1.pop();
            resultList.add((num + up) % 10);
            up = (num + up) / 10;
        }

        while (!stack2.isEmpty()) {
            int num = stack2.pop();
            resultList.add((num + up) % 10);
            up = (num + up) / 10;
        }

        if (up != 0) resultList.add(up);
        if (!resultList.isEmpty()) {
            int size = resultList.size();
            ListNode head = new ListNode(resultList.get(size - 1));
            ListNode rNode = head;
            for (int i = size - 2; i >= 0; i--) {
                rNode.next = new ListNode(resultList.get(i));
                rNode = rNode.next;
            }
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        System.out.println(solution(node, node4));
    }
}
