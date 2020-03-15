package leetcode.contests.contest_180;

import java.util.Iterator;
import java.util.LinkedList;

public class StackWithIncrementOperations {
    LinkedList<Integer> stack;
    int maxSize;
    public StackWithIncrementOperations(int maxSize) {
        stack=new LinkedList<>();
        this.maxSize=maxSize;
    }

    public void push(int x) {
        if(stack.size()<maxSize){
            stack.addFirst(x);
        }
    }

    public int pop() {
        if(stack.isEmpty())return -1;
        int val=stack.peekFirst();
        stack.removeFirst();
        return val;
    }

    public void increment(int k, int val) {
        LinkedList<Integer> nStack=new LinkedList<>();
        int size=stack.size();
        int diff= size-k;
        Iterator<Integer> it =stack.iterator();
        while (it.hasNext()){
            Integer next=it.next();
            if(diff>0){
                nStack.addLast(next);
                diff--;
            }else{
                nStack.addLast(next+val);
            }
        }

        stack=nStack;
    }
}
