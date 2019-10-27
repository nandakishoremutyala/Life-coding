package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        if (minLen == 0) return "";

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (c == s.charAt(i)) continue;
                else {
                    minLen = i;
                    break;
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
