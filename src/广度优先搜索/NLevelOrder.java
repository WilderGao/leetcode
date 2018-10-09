package 广度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WilderGao
 * time 2018-09-10 21:33
 * motto : everything is no in vain
 * description
 */
public class NLevelOrder {
    public List<List<Integer>> solution(NNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<NNode> queue = new LinkedList<>();

        if (root == null){
            return result;
        }else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.getVal());
            queue.offer(root);
            result.add(tmp);
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            while (size > 0){
                NNode nNode = queue.poll();
                if (nNode.getChildren() != null) {
                    for (NNode child : nNode.getChildren()) {
                        if (child != null) {
                            tmpResult.add(child.getVal());
                            queue.offer(child);
                        }
                    }
                }
                size -- ;
            }
            if (!tmpResult.isEmpty()){
                result.add(tmpResult);
            }
        }
        return result;
    }
}
