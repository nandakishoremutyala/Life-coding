package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> in = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        in.add(l1);
        in.add(l2);
        int result = triangle.minimumTotal(in);
        System.out.println(result);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        Integer[][] memo = new Integer[m][m];
        List<Integer> bottom = triangle.get(m - 1);
        // in the last layer, there is no min value
        // you just use their original value
        for (int i = 0; i < bottom.size(); i++) {
            memo[m - 1][i] = bottom.get(i);
        }
        return helper(0, 0, memo, triangle);
    }

    /**
     * x - level
     * y - position
     */
    private int helper(int x, int y, Integer[][] memo, List<List<Integer>> triangle) {
        if (x >= triangle.size() || y >= triangle.get(x).size())
            return 0;
        if (memo[x][y] != null) return memo[x][y];
        int self = triangle.get(x).get(y);
        int left = helper(x + 1, y, memo, triangle) + self;
        int right = helper(x + 1, y + 1, memo, triangle) + self;
        return memo[x][y] = Math.min(left, right);
    }

}
