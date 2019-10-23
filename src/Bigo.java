/**
 * @author WilderGao
 * time 2019-10-21 10:09
 * motto : everything is no in vain
 * description
 */
public class Bigo {
    public boolean solution(TreeNode root) {
        return bigoHelp(root) == -1;
    }

    private int bigoHelp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = bigoHelp(root.left);
        int right = bigoHelp(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }
        int sub = Math.abs(left - right);
        if (sub > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}