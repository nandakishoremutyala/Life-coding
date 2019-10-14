package leetcode.contests.contest_158;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackTheKing {
    QueensThatCanAttackTheKing queensThatCanAttackTheKing;
    boolean[][] board;

    @BeforeEach
    public void init() {
        board=new boolean[8][8];
        queensThatCanAttackTheKing = new QueensThatCanAttackTheKing();
    }

    @Test
    public void firstTest() {
        int[][] queens = new int[][]{
                {0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}
        };
        int[] king = new int[]{0, 0};
        queensThatCanAttackTheKing.queensAttacktheKing(queens, king);
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        board=new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            int[] q=queens[i];
            board[q[0]][q[1]]=true;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            int[] q = queens[i];
            List<Integer> moveUp = moveUp(king, q);
            if (moveUp != null) result.add(moveUp);

            List<Integer> moveDown = moveDown(king, q);
            if (moveDown != null) result.add(moveDown);

            List<Integer> moveLeft = moveLeft(king, q);
            if (moveLeft != null) result.add(moveLeft);

            List<Integer> moveRight = moveRight(king, q);
            if (moveRight != null) result.add(moveRight);

            List<Integer> moveRightDown = moveRightDown(king, q);
            if (moveRightDown != null) result.add(moveRightDown);

            List<Integer> moveLeftUp = moveLeftUp(king, q);
            if (moveLeftUp != null) result.add(moveLeftUp);

        }
        return result;

    }

    public List<Integer> moveUp(int[] king, int[] queen) {
        List<Integer> result=new ArrayList<>();
        if(king[0]!=queen[0])return null;
        else if (king[1]>queen[1])return null;

        else{
            int val=queen[1]+1;
            while (val>=0 && val>king[1]){
                val+=val;
                if(board[queen[0]][val])
                    return null;
                else if(val==king[1]){
                    result.add(queen[0]);
                    result.add(val);
                    return result;
                }
            }
        }

        return null;
    }

    public List<Integer> moveDown(int[] king, int[] queen) {
        List<Integer> result=new ArrayList<>();
        if(king[0]!=queen[0])return null;
        else if (king[1]<queen[1])return null;

        else{
            int val=queen[1];
            while (val<king[1]){
                val+=val;
                if(board[queen[0]][val])
                    return null;
                else if(val==king[1]){
                    result.add(queen[0]);
                    result.add(val);
                    return result;
                }
            }
        }

        return null;
    }

    public List<Integer> moveRight(int[] king, int[] queen) {
        List<Integer> result=new ArrayList<>();
        if(king[1]!=queen[1])return null;
        else if (king[1]<queen[1])return null;

        else{
            int val=queen[0];
            while (val<king[0]){
                val+=val;
                if(board[queen[val]][1])
                    return null;
                else if(val==king[0]){
                    result.add(queen[val]);
                    result.add(1);
                    return result;
                }
            }
        }

        return null;
    }

    public List<Integer> moveLeft(int[] king, int[] queen) {
        return null;
    }


    public List<Integer> moveRightDown(int[] king, int[] queen) {
        return null;
    }

    public List<Integer> moveLeftUp(int[] king, int[] queen) {
        return null;
    }

}
