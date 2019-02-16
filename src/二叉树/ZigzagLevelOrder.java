package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-02-16 09:35
 * motto : everything is no in vain
 * description leetcode 103 二叉树的锯齿形层次遍历
 * 根据剑指offer，锯齿形层次遍历采用的不是队列这种数据结构，而是采用栈，而且采用两个栈，奇数层次放于一个栈中，偶数层次放于另一个栈中
 */
public class ZigzagLevelOrder {
    private List<List<Integer>> solution(TreeNode root) {
        List<Integer> tmp = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        //当前层次是奇数还是偶数，缺省值为0，因为是第0层
        int currentSingleOrDouble = 0;
        int nextRowSingleOrDouble = 1;
        stacks[currentSingleOrDouble].add(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            //如果是奇数层则从左到右进栈，如果是偶数层则从右到左进栈
            TreeNode node = stacks[currentSingleOrDouble].pop();
            tmp.add(node.val);
            if (currentSingleOrDouble == 0) {
                //下一层是奇数层
                if (node.left != null) {
                    stacks[nextRowSingleOrDouble].add(node.left);
                }
                if (node.right != null) {
                    stacks[nextRowSingleOrDouble].add(node.right);
                }
            } else {
                //下一层是偶数层
                if (node.right != null) {
                    stacks[nextRowSingleOrDouble].add(node.right);
                }
                if (node.left != null) {
                    stacks[nextRowSingleOrDouble].add(node.left);
                }
            }
            if (stacks[currentSingleOrDouble].isEmpty()) {
                //这一层被搞定了
                List<Integer> resultIndex = new LinkedList<>(tmp);
                result.add(resultIndex);
                tmp.clear();
                nextRowSingleOrDouble = 1 - nextRowSingleOrDouble;
                currentSingleOrDouble = 1 - currentSingleOrDouble;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        System.out.println(new ZigzagLevelOrder().solution(root));
    }
}
