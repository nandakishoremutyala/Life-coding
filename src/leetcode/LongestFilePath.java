package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LongestFilePath {
    public static void main(String[] args) {
        LongestFilePath longestFilePath=new LongestFilePath();
        Assertions.assertEquals(20,
                longestFilePath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
    public int lengthLongestPath(String input) {
        //"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"

        /**
         * dir \tsubdir1 \tsubdir2  \t\tfile.ext
         *
         * */
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);
        for (String s : input.split("\n")) {
            System.out.println(s);
            int depth = s.lastIndexOf('\t') + 1;
            map.put(depth, s.length() - depth + map.get(depth - 1));
            if (s.contains("."))
                maxLen = Math.max(maxLen, map.get(depth) + depth);
        }
        return maxLen;
    }
}
