package 二叉树;

/**
 * @author WilderGao
 * time 2019-02-13 20:41
 * motto : everything is no in vain
 * description leetcode 101 判断二叉树是否对称
 */
public class IsSymmetric {
    private boolean solution(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            //当两个同时为空的情况下也证明这两个节点是对称的
            return true;
        }
        //一个为空一个不为空的情况下这两个节点则是不对称的
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        //两个值不相等的时候也是不对称的
        if (pRoot1.val != pRoot2.val){
            return false;
        }
        return isSymmetric(pRoot1.left, pRoot2.right) && isSymmetric(pRoot1.right, pRoot2.left);
    }
}
