package leetcode.contests.contest_186;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximumScoreAfterSplittingString {
    MaximumScoreAfterSplittingString maximumScoreAfterSplittingString;
    @BeforeEach
    public void init(){
        maximumScoreAfterSplittingString=new MaximumScoreAfterSplittingString();
    }
    @Test
    public void firstTest(){
        String input="011101";
        int res= maximumScoreAfterSplittingString.maxScore(input);
        Assertions.assertEquals(5,res);
    }
    @Test
    public void secondTest(){
        String input="00111";
        int res= maximumScoreAfterSplittingString.maxScore(input);
        Assertions.assertEquals(5,res);
    }

    @Test
    public void thirdTest(){
        String input="1111";
        int res= maximumScoreAfterSplittingString.maxScore(input);
        Assertions.assertEquals(3,res);
    }
    public int maxScore(String s) {
        int totalZeros=0;
        int totalOnes=0;
        for(char c:s.toCharArray()){
            if(Integer.parseInt(String.valueOf(c))==0)
                totalZeros++;
            else
                totalOnes++;
        }

        int l=0;
        int score=0;
        for(int i=0;i<s.length()-1;i++){
            char c=s.charAt(i);
            if(c=='0'){
                l++;
            }else{
                totalOnes--;
            }
            score=Math.max(score,(l+totalOnes));
        }
        return score;
    }
}
