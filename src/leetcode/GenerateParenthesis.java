package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis=new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(new StringBuilder(""), 0, 0,n, result);

        return result;
    }

    private void helper(StringBuilder sb, int open, int close, int n, List<String> res) {
        if(open == n && close == n) {
            System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            helper(sb, open+1, close, n,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open) {
            sb.append(")");
            helper(sb, open, close+1, n,res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
