package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-22 20:26
 * motto : everything is no in vain
 * description leetcode:返回所有满二叉树的列表
 */
public class AllPossibleFBT {
    public List<TreeNode> solution(int n) {
        return buildTreeHelp(n);
    }

    private List<TreeNode> buildTreeHelp(int n) {
        List<TreeNode> resultNodes = new ArrayList<>();
        if (n == 1) {
            TreeNode node = new TreeNode(0);
            resultNodes.add(node);
            return resultNodes;
        }
        for (int i = 1; i < n; i++) {
            List<TreeNode> leftNodes = buildTreeHelp(i);
            List<TreeNode> rightNodes = buildTreeHelp(n - 1 - i);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    resultNodes.add(node);
                }
            }
        }
        return resultNodes;
    }

    public static void main(String[] args) {
        System.out.println(new AllPossibleFBT().solution(7).size());
    }
}
