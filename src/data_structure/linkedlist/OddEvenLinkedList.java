package data_structure.linkedlist;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(head);
        System.out.println(result.val);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        while (odd != null && even != null) {
            if (odd.next != null)
                odd.next = odd.next.next;
            if (even.next != null)
                even.next = even.next.next;

            odd = odd.next;

            even = even.next;
        }
        if(odd!=null)   odd.next = temp;
        else {
            ListNode cur=head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=temp;
        }
        return head;
    }
}
