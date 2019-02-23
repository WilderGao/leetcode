package 二叉树;

/**
 * @author WilderGao
 * time 2019-02-13 11:22
 * motto : everything is no in vain
 * description leetcode 226 翻转二叉树
 */
public class InvertTree {

    private TreeNode solution(TreeNode root){
        if (root == null) return null;
        if (root.left == null && root.right == null){
            return root;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        if (root.left != null){
            solution(root.left);
        }
        if (root.right!=null){
            solution(root.right);
        }
        return root;
    }
}
