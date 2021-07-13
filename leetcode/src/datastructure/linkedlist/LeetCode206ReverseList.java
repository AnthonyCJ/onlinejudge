package datastructure.linkedlist;

public class LeetCode206ReverseList {
    /**
     * Recursion
     * Time:O(n), Space:O(n)
     * Version 1.0 2021-07-13 by XCJ
     * @param head head of the list
     * @return new head after reversion
     */
    public ListNode reverseList_Recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // reverse the rest
        ListNode newHead = reverseList_Recursion(head.next);
        // reverse the pointer between head and the rest
        head.next.next = head;
        // handle the new tail
        head.next = null;

        return newHead;
    }

    /**
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 1.0 2021-07-13 by XCJ
     * @param head head of the list
     * @return new head after reversion
     */
    public ListNode reverseList_Iteration(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oldHead = head, nextNode = head.next;
        while (oldHead.next != null) {
            // cut
            oldHead.next = nextNode.next;
            // link
            nextNode.next = head;
            // update head
            head = nextNode;
            // handle the next node
            nextNode = oldHead.next;
        }
        return head;
    }
}
