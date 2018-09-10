package 广度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WilderGao
 * time 2018-09-10 13:24
 * motto : everything is no in vain
 * description 树的层次遍历
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrder {
    public List<List<Integer>> solution(TreeNode root){
        //用来存放结果
        List<List<Integer>> result = new ArrayList<>();
        //存放临时节点
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root == null){
            return result;
        }else {
            //添加根节点
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            treeNodes.offer(root);
            result.add(tmp);
        }

        while (!treeNodes.isEmpty()){
            int i = treeNodes.size();
            List<Integer> tmpResult = new ArrayList<>();
            while (i > 0){
                TreeNode tNode = treeNodes.poll();
                if (tNode.left != null){
                    tmpResult.add(tNode.left.val);
                    treeNodes.offer(tNode.left);
                }
                if (tNode.right != null){
                    tmpResult.add(tNode.right.val);
                    treeNodes.offer(tNode.right);
                }
                i --;
            }
            if (!tmpResult.isEmpty()){
                result.add(tmpResult);
            }
        }
        return result;
    }

}
