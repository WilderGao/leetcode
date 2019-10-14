package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-05 15:52
 * motto : everything is no in vain
 * description
 */
public class BuildTree {
    public static TreeNode solution(int[] preOrder, int[] inOrder) {
        return buildTreeHelp(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private static TreeNode buildTreeHelp(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int preIndex = preOrder[preLeft];
        //找到根节点在中序遍历下的位置
        int i;
        for (i = inLeft; i < inRight; i++) {
            if (inOrder[i] == preIndex) {
                break;
            }
        }
        TreeNode node = new TreeNode(preIndex);
        node.left = buildTreeHelp(preOrder, inOrder, preLeft + 1, preLeft + i - inLeft, inLeft, i - 1);
        node.right = buildTreeHelp(preOrder, inOrder, preRight - inRight + i + 1, preRight, i + 1, inRight);
        return node;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode node = solution(preOrder, inOrder);
    }
}
