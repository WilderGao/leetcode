package 链表;

import 二叉树.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-23 14:08
 * motto : everything is no in vain
 * description leetcode 143: 重拍链表  1->2->3->4->5 变成 1->5->2->4->3
 */
public class ReorderList {
    /**
     * 利用栈来解决问题，不过只超过了13%的用户，应该可以再优化
     *
     * @param head 链表头
     */
    public void solution(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head.next;
        ListNode befNode = head;
        while (!stack.isEmpty() && stack.peek() != node && node != null) {
            ListNode tailNode = stack.pop();
            stack.peek().next = null;
            befNode.next = tailNode;
            tailNode.next = node;
            befNode = node;
            node = node.next;
        }
    }

    /**
     * 一种我没有想到的方式：找到中点，中点后半部分逆置，两个链表遍历，交叉合并
     *
     * @param head 链表头
     */
    public void solutionTwo(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        int num = 0;
        while (node != null) {
            num++;
            node = node.next;
        }
        int half = num / 2;
        ListNode secHead = head;
        while (half-- > 0) {
            secHead = secHead.next;
        }

        ListNode firTail = secHead;
        secHead = secHead.next;
        firTail.next = null;

        //现在分成了head和secHead两个为首的链表，进行secHead链表逆置
        ListNode n = secHead;
        ListNode beforeNode, afterNode;
        beforeNode = n;
        n = n.next;
        beforeNode.next = null;
        while (n != null) {
            afterNode = n.next;
            n.next = beforeNode;
            beforeNode = n;
            n = afterNode;
        }

        secHead = beforeNode;
        //现在可以开始冲新排了
        node = head;
        ListNode secNode = secHead;
        while (node != null && secNode != null){
            ListNode afterFirNode = node.next;
            ListNode afterSecNode = secNode.next;
            node.next = secNode;
            secNode.next = afterFirNode;
            node = afterFirNode;
            secNode = afterSecNode;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new ReorderList().solutionTwo(node1);
        System.out.println(node1);
    }
}
