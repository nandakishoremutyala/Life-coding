package prep_2021.geeksforgeeks.dp;

public class LongestEvenLengthSubstringSum {
    public static void main(String[] args) {
        String str = "123123";

        System.out.println(findLength(str, str.length()));
    }

    private static int findLength(String str, int n) {
        // To store cumulative sum from
        // first digit to nth digit
        int sum[] = new int[n + 1];
        sum[0] = 0;

    /* Store cumulative sum of digits
    from first to last digit */
        for (int i = 1; i <= n; i++)

            /* convert chars to int */
            sum[i] = (sum[i - 1] + str.charAt(i - 1)
                    - '0');

        int ans = 0; // initialize result

        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i++) {
            /* Sum of first and second half
            is same than update ans */
                if (sum[i + len / 2] - sum[i] == sum[i + len]
                        - sum[i + len / 2])
                    ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
