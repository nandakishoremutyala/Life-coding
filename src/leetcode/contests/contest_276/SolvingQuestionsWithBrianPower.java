package leetcode.contests.contest_276;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolvingQuestionsWithBrianPower {
    SolvingQuestionsWithBrianPower sqbp;

    @BeforeEach
    public void init() {
        sqbp = new SolvingQuestionsWithBrianPower();
    }

    @Test
    public void firstTest() {
        sqbp.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}});
    }

    long[] cache;

    public long mostPoints(int[][] questions) {
        cache = new long[questions.length];
        return findMax(questions, 0);
    }

    private long findMax(int[][] questions, int position) {
        //System.out.println("pos: " + position + " profit: " + profit);
        if (position >= questions.length) {
            return 0;
        }
        if (cache[position] > 0) return cache[position];
        int points = questions[position][0], jump = questions[position][1];
        return cache[position] = Math.max(points+findMax(questions,
                position + jump + 1
        ), findMax(questions,
                position + 1
        ));
    }
}
