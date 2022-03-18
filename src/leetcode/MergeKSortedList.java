/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int s=lists.length;
        if(s==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(s,(a,b)->a.val-b.val);
        
        for(int i=0;i<s;i++){
            if(lists[i]!=null)
                pq.offer(lists[i]);
        }
        System.out.println(pq);
     
        ListNode head=new ListNode();
        ListNode result=head;
        while(!pq.isEmpty()){
            ListNode curr=pq.peek();
            head.next=pq.poll();
            if(curr.next!=null){
                pq.offer(curr.next);
            }
            
            head=head.next;
        }
        return result.next;
    }
}
