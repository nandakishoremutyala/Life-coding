package leetcode.contests.contest_205;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReplaceQuestionMark {
    ReplaceQuestionMark replaceQuestionMark;
    @BeforeEach
    public void init(){
        replaceQuestionMark=new ReplaceQuestionMark();
    }
    @Test
    public void firstTest(){
        String result = replaceQuestionMark.modifyString("??yw?ipkj?");
        System.out.println(result);
    }
    public String modifyString(String s) {
        if(s.length()==1 && s.charAt(0)=='?')return "a";
        char[] characters=new char[]{'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] arr=s.toCharArray();

        int i=0;
        for (int j = 0; j < arr.length; j++) {
            char c=arr[j];
            if(j==0 && c=='?'){
                if(j<arr.length){
                    while (characters[i]==arr[j+1]){
                        i++;
                        if(i>=26)
                            i=0;
                    }
                    arr[j]=characters[i];
                }
            }else if(c=='?'){
                if(j==arr.length-1){
                    while (characters[i]==arr[j-1]){
                        i++;
                        if(i>=26)
                            i=0;
                    }
                    arr[j]=characters[i];
                }
                else if (j<arr.length){
                    while (characters[i]==arr[j+1]||characters[i]==arr[j-1]){
                        i++;
                        if(i>=26)
                            i=0;
                    }
                    arr[j]=characters[i];
                }

            }
        }

        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}
