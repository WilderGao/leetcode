package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-03 21:03
 * motto : everything is no in vain
 * description leetcode 108:将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public static TreeNode solution(int[] nums) {
        int length = nums.length;
        return buildTreeHelp(nums, 0, length - 1);
    }

    private static TreeNode buildTreeHelp(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTreeHelp(nums, start, middle - 1);
        root.right = buildTreeHelp(nums, middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-10,-3,0,5,9};
        TreeNode root = solution(a);
        System.out.println(root);
    }
}
