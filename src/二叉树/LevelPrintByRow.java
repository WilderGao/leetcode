package 二叉树;

import java.util.ArrayDeque;

/**
 * @author WilderGao
 * time 2019-02-15 20:39
 * motto : everything is no in vain
 * description 层次遍历，每一层一行
 */
public class LevelPrintByRow {
    private void solution(TreeNode root){
        if (root == null) return;
        //需要有两个变量，一个变量保存本行的节点数量，另一个用来保存下一行的节点数量
        int currentRowNum = 1;
        int nextRowNum = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            printNode(node);
            currentRowNum --;
            if (node.left != null){
                deque.add(node.left);
                nextRowNum++;
            }
            if (node.right != null){
                deque.add(node.right);
                nextRowNum++;
            }
            if (currentRowNum == 0){
                System.out.println();
                currentRowNum = nextRowNum;
                nextRowNum = 0;
            }
        }
    }

    private void printNode(TreeNode node){
        System.out.print(node.val);
    }

}
