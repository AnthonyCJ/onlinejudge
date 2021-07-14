package datastructure.linkedlist;

public class LeetCode25ReverseKGroup {
    /**
     * 反转链表（从节点 a 开始，到节点 b 为止）
     * @param a 翻转起始节点（包括节点a）
     * @param b 反转终止节点（不包括节点b）
     * @return 翻转后头节点
     */
    ListNode reverseList(ListNode a, ListNode b) {
        ListNode oldHead = a, newHead = a, nextNode = oldHead.next;
        while (oldHead.next != b) {
            // cut
            oldHead.next = nextNode.next;
            // link
            nextNode.next = newHead;
            // update newHead
            newHead = nextNode;
            // update nextNode
            nextNode = oldHead.next;
        }
        return newHead;
    }

    /**
     * K个一组反转链表
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 1.0 2021-07-13 by XCJ
     * @param head 链表头节点
     * @param k 每组包含的元素个数
     * @return 反转后的新头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1, head);
        ListNode tempDummyHead = dummyHead, tempHead = head, tempTail = head;
        for (int i = 0; i < k; i++) {
            tempTail = tempTail.next;
        }
        // handle dummyHead (the first group)
        dummyHead.next = reverseList(tempHead, tempTail);
        tempDummyHead.next = dummyHead.next;
        // the rest listNodes
        while (true) {
            // find the precursor of the next group
            for (int i = 0; i < k; i++) {
                tempDummyHead = tempDummyHead.next;
            }
            // update tempHead and tempTail
            tempHead = tempDummyHead.next;
            tempTail = tempHead;
            for (int i = 0; i < k; i++) {
                if (tempTail == null)
                    return dummyHead.next;
                else
                    tempTail = tempTail.next;
            }
            tempDummyHead.next = reverseList(tempHead, tempTail);
        }
    }
}
