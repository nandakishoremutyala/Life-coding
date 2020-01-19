package leetcode.contests.contest_172;

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
    }

    @Test
    public void secondTest(){
        List<String> result=printsWordVertically.printVertically("TO BE OR NOT TO BE");
    }
    public List<String> printVertically(String s) {
        int lenRows=0;

        String[] strs = s.split("\\s+");
        for(String str:strs){
            lenRows=Math.max(lenRows,str.length());
        }

        StringBuilder fakeString=new StringBuilder();
        for (int i = 0; i <strs.length ; i++) {
            fakeString.append(" ");
        }

        System.out.println("--"+fakeString.toString()+"--");
        List<StringBuilder> list=new ArrayList<>(lenRows);

        for (int i = 0; i <lenRows ; i++) {
            list.add(i,new StringBuilder(fakeString.toString()));
        }

        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            for (int j = 0; j <str.length() ; j++) {
                char c=str.charAt(j);
                list.get(j).setCharAt(i,c);
            }
        }
        String regex="\\s+$";

        List<String> result=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String string=list.get(i).toString().replaceAll(regex,"");
            System.out.println(string);
            result.add(string);
        }

        return result;

    }
}
