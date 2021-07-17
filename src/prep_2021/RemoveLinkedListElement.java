package prep_2021;

import leetcode.ListNode;

public class RemoveLinkedListElement {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(3);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        removeElements(head,3);
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prev=dummy, curr=head;

        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
            }else
                prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
}
