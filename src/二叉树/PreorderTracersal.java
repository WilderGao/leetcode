package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-09-17 19:59
 * motto : everything is no in vain
 * description 前序遍历迭代版本
 */
public class PreorderTracersal {
    public List<Integer> preorderTracersalHelp(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return result;
    }
}