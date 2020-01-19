package leetcode.contests.contest_172;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintsWordVertically {
    PrintsWordVertically printsWordVertically;
    @BeforeEach
    public void init(){
        printsWordVertically=new PrintsWordVertically();
    }
    @Test
    public void firstTest(){
        List<String> result=printsWordVertically.printVertically("HOW ARE YOU");
        Assertions.assertEquals(3,result.size());
    }

    @Test
    public void secondTest(){
        List<String> result=printsWordVertically.printVertically("TO BE OR NOT TO BE");
        Assertions.assertEquals(3,result.size());
    }
    public List<String> printVertically(String s) {
        //compute the num of rows
        int lenRows=0;
        String[] strs = s.split("\\s+");
        for(String str:strs){
            lenRows=Math.max(lenRows,str.length());
        }

        // computing the number of column and filled with space string
        StringBuilder fakeString=new StringBuilder();
        for (int i = 0; i <strs.length ; i++) {
            fakeString.append(" ");
        }

        List<StringBuilder> list=new ArrayList<>(lenRows);
        for (int i = 0; i <lenRows ; i++) {
            list.add(i,new StringBuilder(fakeString.toString()));
        }

        // Now fill up the table
        // Take each character and place into the table
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            for (int j = 0; j <str.length() ; j++) {
                char c=str.charAt(j);
                list.get(j).setCharAt(i,c);
            }
        }

        // removing the trailing space and generate final output
        String regex="\\s+$";
        List<String> result=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String string=list.get(i).toString().replaceAll(regex,"");
            result.add(string);
        }
        return result;
    }
}
