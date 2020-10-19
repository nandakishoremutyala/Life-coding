package leetcode.contests.contest_211;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        if(s.length()==0)return 0;
        int maxLen=-1;
        Map<Character,Integer> positions=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            positions.put(c,i);
        }
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            int p =positions.get(c);
            if(p==i)continue;
            else{
                int len=p-i-1;
                maxLen=Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}

