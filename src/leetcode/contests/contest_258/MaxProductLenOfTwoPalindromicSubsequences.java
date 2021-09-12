package leetcode.contests.contest_258;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxProductLenOfTwoPalindromicSubsequences {
    public static void main(String[] args) {
        String in="leetcodecom";
        MaxProductLenOfTwoPalindromicSubsequences mx=new MaxProductLenOfTwoPalindromicSubsequences();
        mx.maxProduct(in);

    }
    public int maxProduct(String s) {


        Set<Integer> pal1=new HashSet<>();

        for (int i = 0; i < s.length() ; i++) {
            Set<Integer> pal=computePalLength(i,s);
            print(pal,s);
            if(pal1.size()<pal.size())
                pal1=pal;
        }

        return 0;
    }

    private Set<Integer> computePalLength(int startLocation, String s) {
        int start=startLocation;
        int end=s.length();
        Set<Integer> pal1=new HashSet<>();
        Map<Character,Integer> lastLocation=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            lastLocation.put(s.charAt(i),i);
        }
        while (start<end){
            if(end-start==1) pal1.add(start);
            char target=s.charAt(start);
            if(start==lastLocation.get(target)) start++;
            else{
                int temp=lastLocation.get(target);
                if(temp<end){
                    pal1.add(start);
                    pal1.add(temp);
                    end=temp;
                    start++;
                }else
                    start++;
            }
        }
        return pal1;
    }

    private void print(Set<Integer> s, String str){
        for(int i:s){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println("");
    }
}
