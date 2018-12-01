package 数字;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-12-01 14:44
 * motto : everything is no in vain
 * description leetcode 105
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /    \
 * 15     7
 *
 * 【考察的其实就是深度优先搜索和递归的思想，前序遍历的第一个数就肯定是根节点了，然后根据根节点分左节点和右节点，分别两路递归】
 */
public class BuildTree {
    /**
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 结果二叉树
     */
    public TreeNode solution(int[] preorder, int[] inorder) {
        return createNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode createNode(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        int i = 0;
        for (i = iLeft; i <= iRight; i++) {
            if (preorder[pLeft] == inorder[i]) break;
        }
        //找到根节点
        TreeNode head = new TreeNode(preorder[pLeft]);
        head.left = createNode(preorder, pLeft + 1, pLeft - iLeft + i, inorder, iLeft, i - 1);
        head.right = createNode(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight);
        return head;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new BuildTree().solution(preorder, inorder);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


/**
 * 可以运行，但是时间复杂度太高
 */
//    public TreeNode solution(int[] preorder, int[] inorder){
//        if (preorder.length == 0){
//            return null;
//        }
//        List<Integer> inorderList = new LinkedList<>();
//        //前序遍历的第一个数一定是根节点
//        TreeNode head = new TreeNode(preorder[0]);
//        for (int i : inorder) {
//            inorderList.add(i);
//        }
//        for (int i : preorder) {
//            createNode(i, head, inorderList);
//        }
//        return head;
//    }
//
//    private void createNode(int index, TreeNode node, List<Integer> inorderList){
//        if (inorderList.indexOf(node.val) > inorderList.indexOf(index)){
//            if (node.left != null){
//                createNode(index, node.left, inorderList);
//            }else {
//                node.left = new TreeNode(index);
//            }
//        }else if (inorderList.indexOf(node.val) < inorderList.indexOf(index)){
//            if (node.right != null){
//                createNode(index, node.right, inorderList);
//            }else {
//                node.right = new TreeNode(index);
//            }
//        }
//    }