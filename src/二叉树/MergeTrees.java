package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-22 20:05
 * motto : everything is no in vain
 * description leetcode : 合并两颗二叉树
 */
public class MergeTrees {
    public TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return t1;
        }
        if (t1 == null) {
            return t2;
        }
        t1.val = t1.val + t2.val;
        t1.left = solution(t1.left, t2.left);
        t1.right = solution(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(5);

        root.left = left;
        root.right = right;
        left.left = leftLeft;

        TreeNode root2 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        TreeNode leftRight2 = new TreeNode(4);
        TreeNode rightRight2 = new TreeNode(7);

        root2.left = left2;
        root2.right = right2;
        left2.right = leftRight2;
        right.right = rightRight2;

        TreeNode result = new MergeTrees().solution(root, root2);
        System.out.println(result);
    }
}
