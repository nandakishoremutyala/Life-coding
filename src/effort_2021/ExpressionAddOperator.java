package effort_2021;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    public static void main(String[] args) {
        ExpressionAddOperator expressionAddOperator=new ExpressionAddOperator();
        expressionAddOperator.addOperators("123",6);
    }
    List<String> res=new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(0,num, target,new StringBuilder(String.valueOf(num.charAt(0))),Integer.parseInt(String.valueOf(num.charAt(0))));
        return res;
    }

    private void helper(int start, String nums, int target,StringBuilder sb, int temp){
        System.out.println(sb.toString());
        if(temp==target){
            res.add(new String(sb));
        }
        if(start>=nums.length()) return;
        if(start+1<nums.length()){
            helper(start+1,
                    nums,
                    target,
                    sb.append("+").append(nums.charAt(start+1)),
                    temp+Integer.parseInt(String.valueOf(nums.charAt(start+1))));

            sb.delete(sb.length()-2,sb.length());
            helper(start+1,
                    nums,
                    target,
                    sb.append("-").append(nums.charAt(start+1)),
                    temp-Integer.parseInt(String.valueOf(nums.charAt(start+1))));
            sb.delete(sb.length()-2,sb.length());

            helper(start+1,
                    nums,
                    target,
                    sb.append("*").append(nums.charAt(start+1)),
                    temp*Integer.parseInt(String.valueOf(nums.charAt(start+1))));
            sb.delete(sb.length()-2,sb.length());
        }
    }
}
