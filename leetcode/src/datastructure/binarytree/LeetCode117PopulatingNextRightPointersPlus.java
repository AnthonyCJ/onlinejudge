package datastructure.binarytree;

public class LeetCode117PopulatingNextRightPointersPlus {
    Node lastNode = null;        // lastNode 同行前驱节点指针
    Node nextLeftMost = null;    // nextLeftMost 指向当前节点下一行的最左端节点，处理行首元素时更新

    /**
     * 填充每个节点的下一个右侧节点指针（非满二叉树）
     * Version 1.0 2021-07-18 by XCJ
     * @param root 根节点
     * @return 填充指针后的根节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;   // leftmost 指向当前行的最左端节点
        while (leftmost != null) {
            lastNode = null;    // 换行时 lastNode 置空
            nextLeftMost = null;    // 换行时 nextLeftMost 置空
            // 遍历当前行节点
            for (Node currNode = leftmost; currNode != null; currNode = currNode.next) {
                if (currNode.left != null) {
                    handle(currNode.left);
                }
                if (currNode.right != null) {
                    handle(currNode.right);
                }
            }
            leftmost = nextLeftMost;    // 一行处理完成后，跳转至下一行首元素
        }
        return root;
    }

    public void handle(Node curr) {
        if (lastNode != null) {
            lastNode.next = curr;   // 如果当前节点非行首元素，则更新前驱节点的 next 指针
        }
        if (nextLeftMost == null) {
            nextLeftMost = curr;   // 每一行探测到的第一个非空子节点更新为 nextLeftMost
        }
        lastNode = curr;    // 更新前驱节点指针
    }
}
