package leetcode.contests.contest_137;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemovingAdjacentDuplicates_1047 {
    RemovingAdjacentDuplicates_1047 removingAdjacentDuplicates;

    @BeforeEach
    public void init() {
        removingAdjacentDuplicates = new RemovingAdjacentDuplicates_1047();
    }

    @Test
    public void firstTest() {
        String result= removeDuplicates("abbaca");
        System.out.println(result);
    }

    @Test
    public void SecondTest() {
        String result= removeDuplicates("aaaada");
        System.out.println(result);
    }

    public String removeDuplicates(String S) {
        StringBuilder sb=new StringBuilder(S);
        for (int i = 1; sb.length()>1 && i <sb.length() ; i++) {
            if(sb.charAt(i)==sb.charAt(i-1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i=-2;
                if(i<0)
                    i=0;
            }
        }
        return sb.toString();
    }
}
