package effort_2021;

import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitString {
    public int numSplits(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        Set<Character> set = new HashSet<>();

        for (int i = 0; i <len ; i++) {
            char c=s.charAt(i);
            set.add(c);
            prefix[i]=set.size();
        }
        set.clear();
        for (int i = len-1; i >=0 ; i--) {
            char c=s.charAt(i);
            set.add(c);
            suffix[i]=set.size();
        }

        int ans=0;
        for(int i=1;i<len;i++){
            if(prefix[i-1]==suffix[i])
                ans++;
        }
        return ans;
    }
}
