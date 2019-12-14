package 二叉树;

/**
 * @author WilderGao
 * time 2019-12-14 14:44
 * motto : everything is no in vain
 * description leetcode 543: 二叉树的直径
 */
public class DiameterOfBinaryTree {

    public int solution(TreeNode root) {
        int[] res = new int[]{0};
        maxDepth(root, res);
        return res[0];
    }

    private int maxDepth(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left, res);
        int right = maxDepth(node.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new DiameterOfBinaryTree().solution(root));
    }

}
