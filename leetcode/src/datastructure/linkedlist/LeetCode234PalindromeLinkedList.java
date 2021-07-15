package datastructure.linkedlist;

public class LeetCode234PalindromeLinkedList {
    /**
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 1.0 2021-07-15 by XCJ
     * @param head
     * @return true,  is a palindrome list | false, not a palindrome list
     */
    public ListNode reverse(ListNode head) {
        ListNode oldHead = head, nextNode = oldHead.next;
        while (oldHead.next != null) {
            oldHead.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = oldHead.next;
        }
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
