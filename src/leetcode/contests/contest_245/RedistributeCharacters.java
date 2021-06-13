package leetcode.contests.contest_245;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharacters {
    RedistributeCharacters redistributeCharacters;

    @BeforeEach
    public void init() {
        redistributeCharacters = new RedistributeCharacters();
    }

    @Test
    public void firstTest() {
       boolean result= redistributeCharacters.makeEqual(new String[]{"abc","aabc","bc"});
        Assertions.assertEquals(true,result);
    }
    public boolean makeEqual(String[] words) {
        Map<Character,Integer> counter=new HashMap<>();
        for(String str:words){
            for(char c:str.toCharArray()){
                counter.compute(c,(k,v)->v==null?1:v+1);
            }
        }
        int totalWord=words.length;
        for(Map.Entry<Character,Integer> e:counter.entrySet()){
            int val=e.getValue();
            if(val%totalWord!=0) return false;
        }
        return true;
    }

}
