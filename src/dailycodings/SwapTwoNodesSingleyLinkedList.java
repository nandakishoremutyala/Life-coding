package dailycodings;

import helper.LinkedListNode;

public class SwapTwoNodesSingleyLinkedList {
    static LinkedListNode head=new LinkedListNode(1);
    public static void main(String[] args) {
        head.next=new LinkedListNode(2);
        head.next.next=new LinkedListNode(3);
        head.next.next.next=new LinkedListNode(4);
        LinkedListNode result= swapTwoNodes(head);
        System.out.println(result.val);
    }

    private static LinkedListNode swapTwoNodes(LinkedListNode head) {
        LinkedListNode first=head;
        LinkedListNode second=first.next;

        LinkedListNode res=new LinkedListNode(-1);
        res.next=head.next;

        while (first!=null && second!=null){
            LinkedListNode temp=second.next;
            second.next=first;
            first.next=temp;

            first=first.next;
            if(first!=null)
                second=first.next;
        }
        return res.next;
    }
}
