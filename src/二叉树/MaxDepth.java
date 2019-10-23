package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-20 21:16
 * motto : everything is no in vain
 * description leetcode : 返回二叉树的最大深度
 */
public class MaxDepth {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode leftLeft = new TreeNode(15);
        TreeNode rightLeft = new TreeNode(7);

        root.left = left;
        root.right = right;
        right.left = leftLeft;
        right.right = rightLeft;
        System.out.println(new MaxDepth().solution(root));
    }
}
