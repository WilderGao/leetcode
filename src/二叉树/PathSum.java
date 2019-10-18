package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-02-16 10:53
 * motto : everything is no in vain
 * description leetcode 113 路径总和为sum的结果
 */
public class PathSum {
    private List<List<Integer>> solution(TreeNode root, int sum) {
        int currentSum = 0;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        if (root == null) {
            return result;
        }
        findPath(result, tmp, currentSum, sum, root);
        return result;
    }

    private void findPath(List<List<Integer>> result, List<Integer> tmp, int currentSum, int expectedSum, TreeNode node) {
        currentSum += node.val;
        tmp.add(node.val);
        boolean isLeaf = node.left == null && node.right == null;
        if (currentSum == expectedSum && isLeaf) {
            //结果正确且节点是叶子节点
            List<Integer> resultIndex = new LinkedList<>(tmp);
            result.add(resultIndex);
        }

        if (node.left != null) {
            findPath(result, tmp, currentSum, expectedSum, node.left);
        }
        if (node.right != null) {
            findPath(result, tmp, currentSum, expectedSum, node.right);
        }
        tmp.remove(tmp.size() - 1);
    }
}
