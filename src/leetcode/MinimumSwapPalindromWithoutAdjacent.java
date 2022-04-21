package geeksforgeeks;

public class MinimumSwapPalindromWithoutAdjacent {
    public static void main(String[] args) {
        String input = "adbcdbad";
        int res= countSwap(input);
        System.out.println(res);
    }

    private static int countSwap(String input) {
        StringBuilder sb = new StringBuilder(input);
        int left = 0;
        int right = sb.length() - 1;
        int count = 0;
        while (right > left) {
            if (sb.charAt(left) == sb.charAt(right)) {
                left++;
                right--;
                continue;
            }
            int tempRight = right - 1;
            while (tempRight > left && sb.charAt(left) != sb.charAt(tempRight)) {
                tempRight--;
            }
            if (tempRight <= left) return -1;
            else {
                swapChar(sb, right, tempRight);
                count++;
                left++;
                right--;
            }
        }
        return count;
    }

    private static void swapChar(StringBuilder input, int left, int tempRight) {
        char c = input.charAt(left);
        input.setCharAt(left, input.charAt(tempRight));
        input.setCharAt(tempRight, c);
    }
}
