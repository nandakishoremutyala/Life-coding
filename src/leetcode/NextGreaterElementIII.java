package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII nextGreaterElementIII = new NextGreaterElementIII();
        int val= nextGreaterElementIII.nextGreaterElement(15564);
        System.out.println(val);
    }

    public int nextGreaterElement(int n) {
        String input = convertToString(n);
        int len = input.length();
        int i = len - 1;
        while (i >= 0) {
            if (i - 1 >= 0) {
                if (input.charAt(i) > input.charAt(i - 1)) {
                    input = swap(input, i, i - 1);
                    break;
                }
            }
            i--;
        }
        String left = input.substring(0, i);
        StringBuilder stringBuilder = new StringBuilder(left);
        String string = input.substring(i);
        int[] arr = new int[string.length()];
        int k = 0;
        for (char c : string.toCharArray())
            arr[k++] = Integer.parseInt(String.valueOf(c));

        Arrays.sort(arr);
        for (int j = 0; j < arr.length; j++) {
            stringBuilder.append(arr[j]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
    private String swap(String input, int i, int i1) {
        StringBuilder sb = new StringBuilder(input);
        char temp = sb.charAt(i1);
        sb.setCharAt(i1, sb.charAt(i));
        sb.setCharAt(i, temp);
        return sb.toString();
    }

    public String convertToString(int n) {
        return String.valueOf(n);
    }
}
