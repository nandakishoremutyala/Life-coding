package leetcode.contests.contest_234;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {
    NumberOfDifferentIntegersInString numberOfDifferentIntegersInString;
    @BeforeEach
    public void init(){
        numberOfDifferentIntegersInString=new NumberOfDifferentIntegersInString();
    }
    @Test
    public void firstTest(){
        int res=numberOfDifferentIntegersInString.numDifferentIntegers("aA1b01c001");
        Assertions.assertEquals(res,1);
    }

    @Test
    public void secondTest(){
       int res= numberOfDifferentIntegersInString.numDifferentIntegers("167278959591294");
        Assertions.assertEquals(res,1);
    }
    public int numDifferentIntegers(String word) {
        String[] numbers=word.split("[a-zA-Z]");
        Set<Integer> res=new HashSet<>();
        Set<String> strs=new HashSet<>();
        for(String num:numbers){
            if(num.length()>0) {
                try{
                    int n = Integer.parseInt(num);
                    res.add(n);
                }catch (NumberFormatException ex){
                    strs.add(num);
                }
            }
        }
        return res.size()+strs.size();
    }
}
