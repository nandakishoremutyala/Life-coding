package data_structure.linkedlist;

public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next= new ListNode(3);
       // head.next.next.next=new ListNode(4);

        SplitLinkedListInParts splitLinkedListInParts=new SplitLinkedListInParts();
        splitLinkedListInParts.splitListToParts(head,5);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;
        ListNode[] ans = new ListNode[k];
        cur = root;

        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }
}
