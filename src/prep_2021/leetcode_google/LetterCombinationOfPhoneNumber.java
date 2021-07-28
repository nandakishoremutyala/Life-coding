package prep_2021.leetcode_google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    static List<String> finalResult=new ArrayList<>();
    public static void main(String[] args) {
        letterCombinations("23");
    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> numToString=new HashMap<>();
        numToString.put('1',"");
        numToString.put('2',"abc");
        numToString.put('3',"def");
        numToString.put('4',"ghi");
        numToString.put('5',"jkl");
        numToString.put('6',"mno");
        numToString.put('7',"pqrs");
        numToString.put('8',"tuv");
        numToString.put('9',"wxyz");
        numToString.put('0',"");

        List<String> result=new ArrayList<>();
        helper(0,digits.length(),result,numToString,digits) ;
        return finalResult;

    }

    private static void helper(int start, int end, List<String> result, HashMap<Character,String> numToString, String input){
        if(start==end){
            finalResult=result;
            return;
        }
        char digit=input.charAt(start);
        String digitString=numToString.get(digit);
        if(start==0){
            for(char c:digitString.toCharArray()){
                result.add(String.valueOf(c));
            }
             helper(start+1, end,result,numToString,input);
        }else {
            List<String> tmp = new ArrayList<String>();
            for (char c : digitString.toCharArray()) {

                List<String> intm = new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    String str = result.get(i);
                    String nstr = str + String.valueOf(c);
                    intm.add(nstr);
                }
                tmp.addAll(intm);

            }
            result = tmp;
            helper(start + 1, end, result, numToString, input);
        }
    }

}
