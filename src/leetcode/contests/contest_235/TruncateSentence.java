package leetcode.contests.contest_235;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        String[] strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <k ; i++) {
            sb.append(strs[i]).append(" ");
        }
        sb.deleteCharAt(sb.length());
        return sb.toString();
    }
}
