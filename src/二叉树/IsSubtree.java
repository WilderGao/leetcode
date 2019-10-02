package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-02 19:41
 * motto : everything is no in vain
 * description leetcode 572 另一棵树的子树
 */
public class IsSubtree {
    public static boolean solution(TreeNode s, TreeNode t) {
        if (s == null) return true;
        if (isSameTree(s, t)) {
            return true;
        }
        return solution(s.left, t) || solution(s.right, t);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
