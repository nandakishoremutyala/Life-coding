package prep_2021.geeksforgeeks.dp;

import java.util.Arrays;

public class MinEditDistanceRecursion {
    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int editDist(String str1, String str2, int m,
                        int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (str1.charAt(m) == str2.charAt(n)) return editDist(str1, str2, m - 1, n - 1);

        else {
            return min(1 + editDist(str1, str2, m - 1, n),
                    1 + editDist(str1, str2, m, n - 1),
                    1 + editDist(str1, str2, m - 1, n - 1));
        }
    }

    public static void main(String[] args) {
        int res = editDist("cat", "cut", 2, 2);
        System.out.println(res);
        int res1 = editDist("sunday", "saturday", 5, 7);
        System.out.println(res1);
    }
}
