package leetcode.contests.contest_234;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EvaluateBracketPairOfString {
    EvaluateBracketPairOfString evaluateBracketPairOfString;
    @BeforeEach
    public void init(){
        evaluateBracketPairOfString=new EvaluateBracketPairOfString();
    }
    @Test
    public void firstTest(){
        List<List<String>> list=new ArrayList<>();
        list.add(Arrays.asList("name","bob"));
        list.add(Arrays.asList("age","two"));
        evaluateBracketPairOfString.evaluate("(name)is(age)yearsold",list);
    }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> k=new HashMap<>();
        for(List<String> strs:knowledge){
            k.put(strs.get(0),strs.get(1));
        }
        System.out.println(k);
        Deque<Character> stack=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for (char c:s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                StringBuilder temp=new StringBuilder();
                while(!stack.isEmpty()){
                    temp.append(stack.pollLast());
                }
                temp.deleteCharAt(0);
                if(k.containsKey(temp.toString())){
                    sb.append(k.get(temp.toString()));
                }else{
                    sb.append('?');
                }
            }else if(stack.isEmpty()){
                sb.append(c);
            }else if(!stack.isEmpty()){
                stack.push(c);
            }
        }
        return sb.toString();
    }
}
