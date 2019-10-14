package 二叉树;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-14 13:20
 * motto : everything is no in vain
 * description leetdode 199：二叉树的右视图
 */
public class RightSideView {
    public static List<Integer> solution(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int currentLevelNum = 0;
        int lastLevelNum = 1;
        TreeNode tmp;
        result.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = null;
            while (lastLevelNum > 0) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    tmp = node.left;
                    queue.add(node.left);
                    currentLevelNum++;
                }
                if (node != null && node.right != null) {
                    tmp = node.right;
                    queue.add(node.right);
                    currentLevelNum++;
                }
                lastLevelNum--;
            }
            if (tmp != null) {
                result.add(tmp.val);
            }
            lastLevelNum = currentLevelNum;
            currentLevelNum = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(5);

        root.left = left;
        root.right = right;
        left.right = rightLeft;
        right.right = leftLeft;

        for (Integer i : solution(root)) {
            System.out.println(i+" ");
        }
    }
}


