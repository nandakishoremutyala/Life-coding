package effort_2021;

import leetcode.ListNode;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode tempA=headA;

        while(tempA!=null){
            lenA++;
            tempA=tempA.next;
        }

        ListNode tempB=headB;
        while(tempB!=null){
            lenB++;
            tempB=tempB.next;
        }

        int diff=Math.abs(lenA-lenB);
        System.out.println(diff);

        tempA=headA;
        tempB=headB;
        if(lenA>lenB){
            while(diff>0){
                tempA=tempA.next;
                diff--;
            }
        }else{
            while(diff>0){
                tempB=tempB.next;
                diff--;
            }
        }

        System.out.println(tempA.val);
        System.out.println(tempB.val);
        while(tempA!=null && tempB!=null){
            if(tempA==tempB) return tempA;
            else{
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
        return null;

    }
}
