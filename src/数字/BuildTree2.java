package 数字;

/**
 * @author WilderGao
 * time 2018-12-01 16:24
 * motto : everything is no in vain
 * description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildTree2 {
    public TreeNode solution(int[] inorder, int[] postorder) {
        return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode createTree(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight) return null;
        int i;
        for (i = iLeft; i <= iRight; i++) {
            if (inorder[i] == postorder[pRight]) {
                break;
            }
        }
        //此时i的位置就是根节点的位置
        TreeNode head = new TreeNode(inorder[i]);
        head.left = createTree(inorder, iLeft, i - 1, postorder, pLeft, pLeft - iLeft + i - 1);
        head.right = createTree(inorder, i + 1, iRight, postorder, pRight - iRight + i, pRight - 1);
        return head;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] afterOrder = new int[]{9, 15, 7, 20, 3};
        TreeNode node = new BuildTree2().solution(inorder, afterOrder);
    }
}

