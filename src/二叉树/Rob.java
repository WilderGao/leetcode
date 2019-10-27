package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-23 11:48
 * motto : everything is no in vain
 * description leetcode 337：打家劫舍3（二叉树打劫......）
 */
public class Rob {
    public int solution(TreeNode root) {
        return robHelp(root).val;
    }

    public TreeNode robHelp(TreeNode root) {
        //先把它构建成一颗完整的二叉树，补充节点
        if (root == null) {
            TreeNode node = new TreeNode(0);
            return robHelp(node);
        }
        if (root.left == null && root.right == null) {
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }
        //从底层开始，后序遍历
        root.left = robHelp(root.left);
        root.right = robHelp(root.right);

        root.val = Math.max(root.left.val + root.right.val, root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val);
        return root;
    }
}
