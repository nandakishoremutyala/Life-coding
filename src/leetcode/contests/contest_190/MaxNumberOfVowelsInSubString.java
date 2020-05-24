package leetcode.contests.contest_190;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class MaxNumberOfVowelsInSubString {
    MaxNumberOfVowelsInSubString maxNumberOfVowelsInSubString;
    @BeforeEach
    public void init(){
        maxNumberOfVowelsInSubString=new MaxNumberOfVowelsInSubString();
    }

    @Test
    public void firstTest(){
        String input= "abciiidef";
        int k=3;

        int len= maxNumberOfVowelsInSubString.maxVowels(input,k);
        System.out.println(len);
    }

    @Test
    public void secondTest(){
        String input= "aeiou";
        int k=2;

        int len= maxNumberOfVowelsInSubString.maxVowels(input,k);
        System.out.println(len);
    }

    @Test
    public void thirdTest(){
        String input= "leetcode";
        int k=3;

        int len= maxNumberOfVowelsInSubString.maxVowels(input,k);
        System.out.println(len);
    }

    @Test
    public void fourthTest(){
        String input= "rhythms";
        int k=4;

        int len= maxNumberOfVowelsInSubString.maxVowels(input,k);
        System.out.println(len);
    }

    @Test
    public void fifthTest(){
        String input= "tryhard";
        int k=4;

        int len= maxNumberOfVowelsInSubString.maxVowels(input,k);
        System.out.println(len);
    }

    public int maxVowels(String s, int k) {
        if(s.length()<k)return 0;
        char[] chars=s.toCharArray();
        int count=0;
        for (int i = 0; i <k ; i++) {
            if(isVowel(chars[i]))
                count++;
        }
        int start=1;
        int end=start+k-1;
        int maxCount=count;
        while(end<s.length()){
            if(isVowel(chars[start-1]))
                count--;
            if(isVowel(chars[end]))
                count++;
            maxCount=Math.max(maxCount,count);
            start++;
            end++;
        }

        return maxCount;
    }

    private boolean isVowel(char aChar) {
        HashSet<Character> vowels=new HashSet<>();
        vowels.add('a');vowels.add('A');
        vowels.add('e');vowels.add('E');
        vowels.add('i');vowels.add('I');
        vowels.add('o');vowels.add('O');
        vowels.add('u');vowels.add('U');
        return vowels.contains(aChar);
    }
}
