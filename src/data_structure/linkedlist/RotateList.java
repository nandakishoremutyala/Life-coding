package data_structure.linkedlist;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RotateList rotateList = new RotateList();
        ListNode result = rotateList.rotateRight(head, 2);
        System.out.println(result.val);

        ListNode head1 = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        RotateList rotateList1 = new RotateList();
        ListNode result1 = rotateList1.rotateRight(head1, 4);
        System.out.println(result1.val);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int move = k % N;
        if (move == 0) return head;
        int moveLeft = N - move;
        ListNode rightHead = head;
        cur = head;
        int m = 0;
        while (rightHead != null && m < moveLeft - 1) {
            rightHead = rightHead.next;
            cur = cur.next;
            m++;
        }
        rightHead = rightHead.next;
        cur.next = null;
        ListNode result = rightHead;
        while (m < N - 2) {
            rightHead = rightHead.next;
            m++;
        }
        rightHead.next = head;
        return result;
    }
}
