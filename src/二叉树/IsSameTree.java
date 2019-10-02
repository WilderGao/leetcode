package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-02 17:58
 * motto : everything is no in vain
 * description leetcode 100：相同的树
 */
public class IsSameTree {
    public static boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return solution(p.left, q.left) && solution(p.right, q.right);
    }
}
