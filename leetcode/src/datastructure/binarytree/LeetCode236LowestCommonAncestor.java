package datastructure.binarytree;

public class LeetCode236LowestCommonAncestor {
    private TreeNode ancestorNode;  // 祖先节点

    /**
     * 判断树 root 是否包含 p 或 q（深度优先搜索）
     * @param root 根节点
     * @param p 目标节点1
     * @param q 目标节点2
     * @return true: 子树 root 包含目标节点 false: 子树 root 不包含目标节点
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 递归出口
        if (root == null) {
            return false;
        }
        // 递归调用
        boolean bLeftSon = dfs(root.left, p, q);
        boolean bRightSon = dfs(root.right, p, q);
        /* 后续遍历位 */
        if ((bLeftSon && bRightSon) || ((root == p || root == q) && (bLeftSon || bRightSon))) {
            ancestorNode = root;
        }
        return bLeftSon || bRightSon || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ancestorNode;
    }
}
