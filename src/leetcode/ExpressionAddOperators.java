package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        List<String> result = expressionAddOperators.addOperators("123", 6);
        for (String str : result)
            System.out.println(str);
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, 0, "", num, target);
        return res;
    }

    private void dfs(List<String> res, int idx, long bufVal, long sum,
                     String path, String num, int target) {
        if (idx == num.length()) {
            if (sum + bufVal == target) {
                res.add(path);
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }

            long cur = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                dfs(res, i + 1, cur, sum, path + cur, num, target);
            } else {
                dfs(res, i + 1, cur, sum + bufVal, path + "+" + cur, num, target);
                dfs(res, i + 1, -cur, sum + bufVal, path + "-" + cur, num, target);
                dfs(res, i + 1, bufVal * cur, sum, path + "*" + cur, num, target);
            }
        }
    }
}
