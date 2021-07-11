package datastructure.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
 }
public class Sword6PrintListFromTailToHead {

    /**
     * implemented by stack
     * @param head head of the linkedlist
     * @return an array of reversion
     */
    public int[] reversePrint_Stack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    /**
     * Recursion
     * Time:O(n), Space:O(n)
     * Version 1.0 2021-07-11 by XCJ
     */
    ArrayList<Integer> arrayList = new ArrayList<>();
    public int[] reversePrint_Recursion(ListNode head) {
        recursion(head);
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
    void recursion(ListNode head) {
        if (head == null) return;
        recursion(head.next);
        arrayList.add(head.val);
    }

    /**
     * Iteration
     * Time:O(n), Space:O(1)
     * Version 2.0 2021-07-11 by XCJ
     * @param head head of the list
     * @return an array of reversion
     */
    public int[] reversePrint_Iteration(ListNode head) {
        if (head == null) return new int[0];
        ListNode oldHead = head, nextNode = head.next;
        int size = 1;
        while (oldHead.next != null) {
            // cut
            oldHead.next = nextNode.next;
            // link
            nextNode.next = head;
            // update head
            head = nextNode;
            // iterate
            nextNode = oldHead.next;
            size++;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++ ) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
