package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-03 16:07
 * motto : everything is no in vain
 * description leetcode 95:不同的二叉树2
 */
public class GenerateTrees {
    public static List<TreeNode> solution(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTreeHelp(0, n);
    }

    private static List<TreeNode> generateTreeHelp(int start, int end) {
        List<TreeNode> subTreeList = new ArrayList<>();
        if (start > end) {
            subTreeList.add(null);
            return subTreeList;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreeHelp(start, i - 1);
            List<TreeNode> right = generateTreeHelp(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
