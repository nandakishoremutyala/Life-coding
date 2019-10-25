package data_structure.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode root = reverseLinkedListII.reverseBetween(head, 2, 4);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n && m == 1 || head == null) return head;

        // mNode is the node at position m, mParent is the parent of mNode
        ListNode current = head, previous = null, mParent = null, mNode = null;

        int position = 1;

        while (true) {
            ListNode next = current.next;

            if (position == m) {
                mParent = previous;
                mNode = current;
            }

            if (position >= m) {
                current.next = previous;

                if (position == n) {
                    mNode.next = next;
                    if (mParent != null) mParent.next = current;
                    else head = current;
                    break;
                }
            }

            position++;
            previous = current;
            current = next;
        }

        return head;
    }
}
