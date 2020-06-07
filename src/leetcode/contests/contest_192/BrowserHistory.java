package leetcode.contests.contest_192;

import java.util.ArrayDeque;
import java.util.Stack;

public class BrowserHistory {

    /***
     * ["BrowserHistory","visit",   "back","back","forward","forward","visit","visit","back"]
     * [                ["zav.com"],["kni.com"],[7],[7],[5],[1],["pwrrbnw.com"],["mosohif.com"],[9]]
     * */
    public static void main(String[] args) {
        BrowserHistory bh=new BrowserHistory("Leetcode");
      /*  bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linkedin.com");
        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));*/

        bh.visit("zav.com");
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        System.out.println(bh.forward(1));
        bh.visit("pwrrbnw.com");
        bh.visit("mosohif.com");
        System.out.println(bh.back(1));

    }

    Stack<String> stack;
    Stack<String> historyStack;
    boolean lastCallForward=false;
    public BrowserHistory(String homepage) {
        System.out.println("null");
        stack=new Stack<>();
        historyStack=new Stack<>();
        stack.push(homepage);
    }

    public void visit(String url) {
        if(lastCallForward){
            historyStack.clear();
        }
        System.out.println("null");
        stack.push(url);
    }

    public String back(int steps) {
        lastCallForward=false;
        int count=0;
        while (count<steps){
            String h =stack.peek();
            historyStack.add(h);
            stack.pop();
            if(stack.isEmpty()) return h;
            count++;
        }

        if(!stack.isEmpty())return stack.peek();
        else return null;
    }

    public String forward(int steps) {
        lastCallForward=true;
        int count=0;
        while (count<steps){
            if(!historyStack.isEmpty()) {
                String h=historyStack.peek();
                stack.add(h);
                historyStack.pop();
            }
            count++;
        }
        return stack.peek();
    }

}