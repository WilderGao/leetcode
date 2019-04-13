package jianzhi;

/**
 * @author WilderGao
 * time 2019-01-30 17:14
 * motto : everything is no in vain
 * description 重建二叉树，根据前序遍历和中序遍历构建二叉树，前提是不含重复的数字
 */
public class Seven {
    /**
     * 构建二叉树
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return 二叉树根节点
     */
    private Node construct(int[] preOrder, int[] inOrder) {
        //前序遍历的第一个数字是根节点
        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0) {
            return null;
        }
        int length = preOrder.length;
        return constructCore(preOrder, inOrder, 0, length, 0, length);
    }

    private Node constructCore(int[] preOrder, int[] inOrder, int preStartIndex, int preEndIndex, int inStartIndex,
                               int inEndIndex) {
        int rootNum = preOrder[preStartIndex];
        Node root = new Node();
        root.value = rootNum;
        //然后找根节点在中序遍历中的位置
        int rootIndex = preStartIndex;
        for (int i = inStartIndex; i < inEndIndex; i++) {
            if (inOrder[i] == rootNum) {
                rootIndex = i;
                break;
            }
        }
        if (preStartIndex == preEndIndex) {
            return root;
        }

        //中序遍历根节点左边的肯定是根节点的左子树部分，右边则是右子树部分，然后分别使用递归来进行操作
        int leftLength = rootIndex - preStartIndex;
        if (leftLength > 0) {
            root.left = constructCore(preOrder, inOrder, preStartIndex, preStartIndex + leftLength, inStartIndex,
                    rootIndex - 1);
        }
        root.right = constructCore(preOrder, inOrder, preStartIndex + leftLength + 1, preEndIndex, rootIndex + 1,
                inEndIndex);
        return root;

    }

    class Node {
        int value;
        Node left;
        Node right;
    }
}

