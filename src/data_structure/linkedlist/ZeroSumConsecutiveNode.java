package data_structure.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumConsecutiveNode {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        ZeroSumConsecutiveNode zeroSumConsecutiveNode = new ZeroSumConsecutiveNode();
        zeroSumConsecutiveNode.removeZeroSumSublists(head);*/

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(-2);
        ZeroSumConsecutiveNode zeroSumConsecutiveNode = new ZeroSumConsecutiveNode();
        zeroSumConsecutiveNode.removeZeroSumSublists(head);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                cur = map.get(sum).next;
                int key = sum + cur.val;
                while (key != sum) {
                    map.remove(key);
                    cur = cur.next;
                    key += cur.val;
                }
                map.get(sum).next = cur.next;
            } else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
