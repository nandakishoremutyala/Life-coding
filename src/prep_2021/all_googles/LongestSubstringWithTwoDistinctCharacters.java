package prep_2021.all_googles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithTwoDistinctCharacters {
    LongestSubstringWithTwoDistinctCharacters longestSubstringWithTwoDistinctCharacters;
    @BeforeEach
    public void init(){
        longestSubstringWithTwoDistinctCharacters= new LongestSubstringWithTwoDistinctCharacters();
    }

    @Test
    public void firstTest(){
        longestSubstringWithTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct("eceba");
    }

    @Test
    public void secondTest(){
        longestSubstringWithTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int k=2;
        int res=0;

        Map<Character,Integer> count=new HashMap<>();
        Set<Character> set=new HashSet<>();
        int len=s.length();
        if(len<=k)return len;

        int start=0;
        int end=0;
        while(start<=end && end<len){
            char c=s.charAt(end);
            count.put(c,count.getOrDefault(c,0)+1);
            set.add(c);

            if(set.size()<=k){
                res=Math.max(res,end-start+1);
            }
            if(set.size()>k){

                while(set.size()>k){
                    char ch=s.charAt(start);
                    if(count.get(ch)>0){
                        count.put(ch,count.get(ch)-1);
                    }
                    if(count.get(ch)==0){
                        set.remove(ch);
                    }
                    start++;
                }
            }
            end++;
            System.out.println(res);
        }

        return res;
    }
}
