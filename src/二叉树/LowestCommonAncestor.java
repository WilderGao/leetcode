package 二叉树;

/**
 * @author wilder
 * @date 19-3-1 上午9:23
 * description leetcode 235 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    private TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val) ||
                    (root.val == p.val && root.val == q.val)) {
                return root;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
        }
        return null;
    }
}
