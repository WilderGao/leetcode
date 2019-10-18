package 二叉树;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-16 11:29
 * motto : everything is no in vain
 * description leetcode 98:验证二叉搜索树
 */
public class IsValidBST {
    public boolean solution(TreeNode node) {
        int beforeNum = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode top = stack.pop();
                if (top.val >= beforeNum) {
                    beforeNum = top.val;
                } else {
                    return false;
                }
                node = top.right;
            }
        }
        return true;
    }
}
