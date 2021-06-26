package datastructure.linkedlist;

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
    public int[] reversePrintStack(ListNode head) {
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
}
