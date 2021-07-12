package datastructure.linkedlist;

public class Sword35CopyRandomList {
    public Node copyRandomList_Violence(Node head) {
        if (head == null) return null;
        // copy the values
        Node newHead = new Node(head.val);
        Node nextNew = newHead, nextOld = head;
        while (nextOld.next != null) {
            nextNew.next = new Node(nextOld.val);
            nextNew = nextNew.next;
            nextOld = nextOld.next;
        }
        nextNew = newHead;
        nextOld = head;
        while (nextOld.next != null) {
            nextNew.random = nextOld.random;
            nextNew = nextNew.next;
            nextOld = nextOld.next;
        }
        // copy random pointers

        return newHead;
    }



    public void insertion(Node head) {
        Node ptrSource = head, ptrNext = ptrSource.next;
        while (ptrSource != null) {
            ptrNext = ptrSource.next;
            ptrSource.next = new Node(ptrSource.val);
            ptrSource.next.next = ptrNext;
            ptrSource = ptrNext;
        }
    }

    public void updateRandomPointers(Node head) {
        Node ptrSource = head;
        while (ptrSource != null) {
            ptrSource.next.random = ptrSource.random == null ? null : ptrSource.random.next;
            ptrSource = ptrSource.next.next;
        }
    }

    public Node separation(Node head) {
        Node ptrSource = head, newHead = head.next, ptrCopy = head.next;
        while (ptrCopy.next != null) {
            ptrSource.next = ptrCopy.next;
            ptrCopy.next = ptrCopy.next.next;
            ptrSource = ptrSource.next;
            ptrCopy = ptrCopy.next;
        }
        ptrSource.next = null;  // handle the old tail
        return newHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        insertion(head);
        updateRandomPointers(head);
        return separation(head);
    }
}
