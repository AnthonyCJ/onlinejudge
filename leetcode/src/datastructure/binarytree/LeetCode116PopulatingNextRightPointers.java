package datastructure.binarytree;

public class LeetCode116PopulatingNextRightPointers {
    /**
     * Recursion
     * Version 1.0 2021-07-17 by XCJ
     * Time: O(n), Space: O(height)
     * @param root root of the tree to populate the next right pointers
     * @return root after connection
     */
    public Node connect_Recursion(Node root) {
        if (root == null) return null;
        connectTwoNodes(root.left, root.right);
        return root;
    }
    // 递归方法实现
    public void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /* 前序遍历位置 */
        // 连接参数传入的两个节点
        node1.next = node2;

        // 递归地连接相同父节点的两个子节点
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);
        // 递归地连接跨父节点的两个子节点
        connectTwoNodes(node1.right, node2.left);
    }


    /**
     * Iteration
     * Version 2.0 2021-07-17 by XCJ
     * Time: O(n), Space: O(1)
     * @param root root of the tree to populate the next right pointers
     * @return root after connection
     */
    public Node connect_Iteration(Node root) {
        if (root == null) return null;

        // 从根节点开始
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历该层节点形成的链表，为下一层的节点建立 next 指针
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) head.right.next = head.next.left;
                // 指针向后移动
                head = head.next;
            }
            // 迭代至下一层最左节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
