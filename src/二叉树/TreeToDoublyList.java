package 二叉树;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-18 20:05
 * motto : everything is no in vain
 * description leetcode : 二叉搜索树转为双向链表
 */
public class TreeToDoublyList {
    public TreeNode solutioin(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode pre = null;
        TreeNode head = pre;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (pre == null) {
                    head = node;
                    node.left = null;
                } else {
                    pre.right = node;
                    node.left = pre;
                }
                pre = node;
                root = node.right;
            }
        }
        if (head != null) {
            pre.right = head;
            head.left = pre;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode rightLeft = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = rightLeft;

        TreeNode head = new TreeToDoublyList().solutioin(root);
    }
}
