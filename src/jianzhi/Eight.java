package jianzhi;

/**
 * @author WilderGao
 * time 2019-04-12 10:00
 * motto : everything is no in vain
 * description 找中序遍历的下一个节点
 */
public class Eight {
    private Node getNext(Node pNode) {
        if (pNode == null) {
            return null;
        }
        Node pNext = null;
        if (pNode.right != null) {
            Node pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (pNode.parent != null) {
            Node current = pNode;
            Node parent = pNode.parent;
            while (parent != null && current == parent.right){
                current = parent;
                parent = parent.parent;
            }
            pNext = parent;
        }
        return pNext;
    }


    class Node {
        int value;
        Node parent;
        Node left;
        Node right;
    }
}
