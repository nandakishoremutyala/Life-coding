package leetcode.contests.contest_243;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumValueAfterInsertion {
    MaximumValueAfterInsertion maximumValueAfterInsertion;
    @BeforeEach
    public void init(){
        maximumValueAfterInsertion=new MaximumValueAfterInsertion();
    }
    @Test
    public void firstTest(){
        maximumValueAfterInsertion.maxValue("28824579515",8);
    }

    @Test
    public void secondTest(){
        String val=maximumValueAfterInsertion.maxValue("-55",2);
        System.out.println(val);
    }

    @Test
    public void thirdTest(){
        maximumValueAfterInsertion.maxValue("99",9);
    }

    @Test
    public void fourthTest(){
       String val= maximumValueAfterInsertion.maxValue("-132",3);
        System.out.println(val);
    }

    @Test
    public void fifthTest(){
        String val= maximumValueAfterInsertion.maxValue("-13",2);
        System.out.println(val);
    }
    public String maxValue(String s, int x) {
        StringBuilder res = new StringBuilder();

        if(s.charAt(0) == '-'){
            res.append(s.charAt(0));
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) - '0' > x){
                    res.append(x).append(s.substring(i));
                    return res.toString();
                }
                res.append(s.charAt(i));
            }
        } else {
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) - '0'  < x) {
                    res.append(x).append(s.substring(i));
                    return res.toString();
                }
                res.append(s.charAt(i));
            }
        }
        return res.append(x).toString();
    }
}
