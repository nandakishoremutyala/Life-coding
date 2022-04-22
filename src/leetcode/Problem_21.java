package leetcode;

import java.util.PriorityQueue;

public class Problem_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(2, (a, b) -> a.val - b.val);
        if (list1 != null)
            pq.offer(list1);
        if (list2 != null)
            pq.offer(list2);
        while (!pq.isEmpty()) {
            ListNode t = pq.poll();
            head.next = new ListNode(t.val);
            head = head.next;
            if (t.next != null) {
                pq.offer(t.next);
            }
        }
        return dummy.next;
    }
}
