package practice;

public class Permutation {
    public static void main(String[] args) {
        String input = "ABC";
        permute(input, 0, input.length() - 1);
    }

    private static void permute(String input, int start, int length) {
        if (start == length)
            System.out.println(input);
        else {
            for (int i = start; i <= length; i++) {
                input = swap(input, start, i);
                permute(input, start + 1, length);
                input = swap(input, start, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
