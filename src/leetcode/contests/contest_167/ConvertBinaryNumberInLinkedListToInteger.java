package leetcode.contests.contest_167;

import leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertBinaryNumberInLinkedListToInteger {
    ConvertBinaryNumberInLinkedListToInteger convertBinaryNumberInLinkedListToInteger;
    @BeforeEach
    public void init(){
        this.convertBinaryNumberInLinkedListToInteger=new ConvertBinaryNumberInLinkedListToInteger();
    }
    @Test
    public void whenLinkedLisHasThreeElements(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(0);
        head.next.next=new ListNode(1);
        int actual= convertBinaryNumberInLinkedListToInteger.getDecimalValue(head);
        Assertions.assertEquals(5,actual);
    }

    @Test
    public void whenLinkedLisHasOneElement(){
        ListNode head=new ListNode(0);
        int actual= convertBinaryNumberInLinkedListToInteger.getDecimalValue(head);
        Assertions.assertEquals(0,actual);
    }

    @Test
    public void whenLinkedLisHasOneElementWhichIsOne(){
        ListNode head=new ListNode(1);
        int actual= convertBinaryNumberInLinkedListToInteger.getDecimalValue(head);
        Assertions.assertEquals(1,actual);
    }

    @Test
    public void whenLinkedLisHasTwoElementsWhichIsZero(){
        ListNode head=new ListNode(0);
        head.next=new ListNode(0);
        int actual= convertBinaryNumberInLinkedListToInteger.getDecimalValue(head);
        Assertions.assertEquals(0,actual);
    }
    public int getDecimalValue(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while (head!=null){
            sb.append(head.val);
            head=head.next;
        }
        int result=Integer.parseInt(sb.toString(), 2);
        return result;
    }
}
