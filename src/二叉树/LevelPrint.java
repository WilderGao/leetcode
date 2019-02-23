package 二叉树;

import java.util.ArrayDeque;

/**
 * @author WilderGao
 * time 2019-02-15 20:29
 * motto : everything is no in vain
 * description leetcode 层次遍历二叉树
 */
public class LevelPrint {
    private void solution(TreeNode root){
        if (root == null){
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //获得队列中的第一个节点
            TreeNode node = queue.pop();
            printNode(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    private void printNode(TreeNode node){
        System.out.print(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(5);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        right.left = rightLeft;

        new LevelPrint().solution(root);
    }
}
