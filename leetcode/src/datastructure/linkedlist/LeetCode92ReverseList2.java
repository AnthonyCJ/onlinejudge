package datastructure.linkedlist;

public class LeetCode92ReverseList2 {

    ListNode successor = null;  // 后继节点
    // 反转以 head 为起点的前 n 个节点，返回新的头节点
    public ListNode reverseN(ListNode head, int n) {
        // 递归出口
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 递归方程，处理剩余部分
        ListNode newHead = reverseN(head.next, n - 1);
        // 将已反转的剩余部分指向 head 节点
        head.next.next = head;
        // 连接反转部分和未反转部分
        head.next = successor;
        return newHead;
    }
    /**
     * Recursion
     * Time:O(n), Space:O(n)
     * Version 1.0 2021-07-13 by XCJ
     * @param head head of the list
     * @param left start reversion at index of left
     * @param right end reversion at index of right
     * @return head of the list after reversion
     */
    public ListNode reverseBetween_Recursion(ListNode head, int left, int right) {
        // 递归出口
        if (left == 1) {
            // 相当于反转以 head 为头节点的前 n 个元素
            return reverseN(head, right);
        }
        // 如果不符合条件，则递归前进至递归出口
        head.next = reverseBetween_Recursion(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 1.0 2021-07-13 by XCJ
     * @param head head of the list
     * @param left start reversion at index of left
     * @param right end reversion at index of right
     * @return head of the list after reversion
     */
    public ListNode reverseBetween_Iteration(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1); dummyHead.next = head;
        // find the precursor of the node to be reversed
        ListNode preNode = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        ListNode oldHead = preNode.next;
        ListNode nextNode = oldHead.next;
        for (int i = 0; i < right - left; i++) {
            // cut
            oldHead.next = nextNode.next;
            // link
            nextNode.next = preNode.next;
            // update head
            preNode.next = nextNode;
            // update nextNode
            nextNode = oldHead.next;
        }

        return dummyHead.next;
    }
}
