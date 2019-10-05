package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-05 11:39
 * motto : everything is no in vain
 * description leetcode 230:二叉树第k小的值
 */
public class KthSmallest {
    private static int count = 0;

    public static int solution(TreeNode root, int k) {
        count = k;
        return kthSmallestHelp(root);
    }

    private static int kthSmallestHelp(TreeNode root) {
        if (root == null) return -1;
        int val = kthSmallestHelp(root.left);
        if (count == 0) return val;
        --count;
        if (count == 0) return root.val;
        return kthSmallestHelp(root.right);
    }

}
