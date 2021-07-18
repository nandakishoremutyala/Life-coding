package prep_2021.leetcode_google;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
    public static void main(String[] args) {
        isValid("([)]");
    }
    public static boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<Character>();
        if(s.length()==1) return false;
        for(char c:s.toCharArray()){
            if(c==')'||c==']'||c=='}'){
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    char pc=stack.peek();
                    if(c==')' && pc=='('){
                        stack.pop();
                    }
                    else if(c=='}' && pc=='{') {
                        stack.pop();
                    }
                    else if(c==']' && pc=='[') {
                        stack.pop();
                    }
                    else return false;
                }

            }
            else
                stack.push(c);
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
