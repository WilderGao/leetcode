package 二叉树;

/**
 * @author wilder
 * @date 19-3-10 下午9:31
 * description
 */
public class IsBalanced {
    private boolean solution(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode root) {
        if (root == null) return 0;
        int left = balanced(root.left);
        int right = balanced(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
