package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePairs {
    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        palindromePairs.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
    Set<String> seen=new HashSet<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                StringBuilder sb = new StringBuilder(words[i]);
                sb.append(words[j]);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                if (isPalindrome(sb.toString())){
                    res.add(list);
                    seen.add(sb.toString());
                };

                sb.setLength(0);
                List<Integer> list1 = new ArrayList<>();
                list1.add(j);
                list1.add(i);
                sb.append(words[j]);
                sb.append(words[i]);
                if (isPalindrome(sb.toString())) {
                    seen.add(sb.toString());
                    res.add(list1);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        if(seen.contains(str))return true;
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
