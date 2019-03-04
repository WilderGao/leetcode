package 二叉树;

/**
 * @author WilderGao
 * time 2019-02-21 20:53
 * motto : everything is no in vain
 * description leetcode 235 二叉搜索树的最近公共祖先
 *
 * 一定要利用二叉搜索树的性质啊
 */
public class LowestCommonAncestor {

    private TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > Math.max(p.val, q.val)){
            return solution(root.left, p, q);
        }else if (root.val < Math.min(p.val, q.val)){
            return solution(root.right, p, q);
        }else {
            return root;
        }
    }
}
