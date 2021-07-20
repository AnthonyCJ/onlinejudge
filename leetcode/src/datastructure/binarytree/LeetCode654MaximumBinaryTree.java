package datastructure.binarytree;

public class LeetCode654MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 以数组完整区间作为起始状态调用递归构造函数
        return constructBinaryTree(nums, 0, nums.length - 1);
    }

    /**
     * 递归_构造最大二叉树
     * Version 1.0 2021-07-20 by XCJ
     * @param nums int[] 存储节点值
     * @param low 数组查询区间下界
     * @param high 数组查询区间上界
     * @return TreeNode root 最大二叉树根节点
     */
    public TreeNode constructBinaryTree(int[] nums, int low, int high) {
        // 递归出口
        if (low > high) {
            return null;
        }
        // 找到数组中的最大值
        int maxValIndex = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                maxValIndex = i;
                maxVal = nums[i];
            }
        }
        /* 前序遍历位置 */
        // 构造根节点
        TreeNode root = new TreeNode(maxVal);
        // 递归地构造左右子树
        root.left = constructBinaryTree(nums, low, maxValIndex - 1);
        root.right = constructBinaryTree(nums, maxValIndex + 1, high);

        return root;
    }
}
