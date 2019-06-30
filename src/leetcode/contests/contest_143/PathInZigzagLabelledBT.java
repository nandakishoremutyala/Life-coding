package leetcode.contests.contest_143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PathInZigzagLabelledBT {
    PathInZigzagLabelledBT mPathInZigzagLabelledBT;

    @BeforeEach
    public void init() {
        mPathInZigzagLabelledBT = new PathInZigzagLabelledBT();
    }

    @Test
    public void firstTest() {
        List<Integer> result = mPathInZigzagLabelledBT.pathInZigZagTree(14);
        Assertions.assertEquals(4, result.size());

    }

    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> result = new ArrayList<>();
        System.out.println(label);

        while (label > 1) {
            result.add(label);
            int curLevel = computeLevelAndDirection(label);
            if (curLevel % 2 == 0) {
                int curLevelStart = (int) Math.pow(2, curLevel - 1);
                int distance = label - curLevelStart;
                int prevLevel = curLevel - 1;
                int next = (int) Math.pow(2, prevLevel) - 1 - distance / 2;
                label = next;
            } else {
                int distance = (int) Math.pow(2, curLevel) - 1 - label;
                int preLevel = curLevel - 1;
                int prevLevelStart = (int) Math.pow(2, preLevel - 1);
                int next = prevLevelStart + distance / 2;
                label = next;
            }
        }
        result.add(label);
        Collections.reverse(result);
        return result;
    }

    private int computeLevelAndDirection(int label) {
        int n = 0;
        while (Math.pow(2, n) <= label) {
            n++;
        }
        return n;
    }
}
