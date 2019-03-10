package 二叉树;

/**
 * @author wilder
 * @date 19-3-1 上午9:15
 * description leetcode 236
 */
public class LowestCommonAncestor2 {
    private TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
