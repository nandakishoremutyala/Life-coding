package leetcode.contests.contest_239;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplittingStringIntoDescendingConsecutiveValues {
    SplittingStringIntoDescendingConsecutiveValues splts;
    @BeforeEach
    public void init(){
        splts=new SplittingStringIntoDescendingConsecutiveValues();
    }
    @Test
    public void firstTest(){
        boolean result=splts.splitString("1234");
        System.out.println(result);
    }
    public boolean splitString(String s) {
        int len=s.length()/2+1;
        int window=1;
        int start=0;
        boolean res=true;
        while (window<=len){
            start=0;
            int prev=Integer.parseInt(s.substring(start,start+window));
            if(prev==0)
                start=1;
            start=start+window;
            while(start<s.length()){

                int head= Math.min((start + window), s.length());
                if(start==head)
                    break;
                int curr=Integer.parseInt(s.substring(start,head));
                if(curr==0){
                    start++;
                    continue;
                };
                start=start+window;
                if(prev-curr!=1){
                    res=false;
                    break;
                }else if(prev-curr==1){
                    res=true;
                }
                prev=curr;
            }
            if(res && start>=s.length()-1) {
                res = true;
                break;
            }
            window++;
        }
        return res;

    }
}
