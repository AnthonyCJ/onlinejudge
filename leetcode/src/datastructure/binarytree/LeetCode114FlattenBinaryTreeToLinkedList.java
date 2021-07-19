package datastructure.binarytree;

public class LeetCode114FlattenBinaryTreeToLinkedList {
    /**
     * 递归_二叉树展开为链表
     * Version 2.0 2021-07-19 by XCJ
     * Time: O(n), Space: O(n)
     * @param root 二叉树根节点
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 先处理左右子树
        flatten(root.left);
        flatten(root.right);
        /* 后序遍历位置 */
        // 保存原右子树
        TreeNode rightTree = root.right;
        // 左子树移动至右子树
        root.right = root.left;
        root.left = null;
        // 找到最右节点
        TreeNode rightMost = root;
        while (rightMost.right != null) {
            rightMost = rightMost.right;
        }
        // 原右子树连接至最右节点
        rightMost.right = rightTree;
    }

    /**
     * 迭代_二叉树展开为链表
     * Version 2.0 2021-07-19 by XCJ
     * Time: O(n), Space: O(1)
     * @param root 二叉树根节点
     */
    public void flatten_Iteration(TreeNode root) {
        TreeNode currNode = root;
        while (currNode != null) {
            if (currNode.left != null) {
                // find predecessor
                TreeNode predecessor = currNode.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            }
            currNode = currNode.right;
        }
    }
}
