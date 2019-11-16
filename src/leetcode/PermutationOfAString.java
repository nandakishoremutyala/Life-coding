package leetcode;

public class PermutationOfAString {
    public static void main(String[] args) {
        PermutationOfAString permutationOfAString=new PermutationOfAString();
        permutationOfAString.checkInclusion("ab","eidbaooo");
    }
    boolean result = false;
    public boolean checkInclusion(String s1, String s2) {
        try {
            permute(s1, 0, s1.length() - 1, s2);
        } catch (Exception e) {
        }
        return result;
    }

    public void permute(String str, int start, int end, String s2) throws Exception {
        if (start == end) {
            int o = s2.indexOf(str);
            if (o >= 0) {
                result = true;
                throw new RuntimeException("");
            }
        }
        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end, s2);
            str = swap(str, i, start);
        }
    }

    public String swap(String str, int start, int end) {
        char[] sb = str.toCharArray();
        char temp = sb[start];
        sb[start] = sb[end];
        sb[end] = temp;
        return String.valueOf(sb);
    }
}
