package datastructure.binarytree;

public class LeetCode226InvertTree {
    /**
     * Recursion
     * Version 1.0 2021-07-17 by XCJ
     * @param root root of the tree to be inverted
     * @return root of the tree after inversion
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归出口
        if (root == null) {
            return null;
        }
        // 交换子树
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 递归处理子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


