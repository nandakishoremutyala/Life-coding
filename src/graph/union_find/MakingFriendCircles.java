package graph.union_find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MakingFriendCircles {
    MakingFriendCircles makingFriendCircles;

    class FriendCircle {
        int[] friends;
        int[] ranks;
        int circles;

        FriendCircle(int num) {
            this.circles = num;
            this.friends = new int[num];
            this.ranks = new int[num];
            for (int i = 0; i < num; i++) {
                friends[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int x) {
            while (friends[x] != x) {
                friends[x] = friends[friends[x]];
                x = friends[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (ranks[rootX] < ranks[rootY]) {
                    friends[rootY] = rootX;
                } else if (ranks[rootY] < ranks[rootX]) {
                    friends[rootX] = rootY;
                } else {
                    friends[rootX] = rootY;
                    ranks[rootY] += ranks[rootY];
                }
                this.circles--;
            }
        }

    }

    @BeforeEach
    public void init() {
        makingFriendCircles = new MakingFriendCircles();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        Assertions.assertEquals(2, makingFriendCircles.findCircleNum(input));
    }

    @Test
    public void secondTest() {
        int[][] input = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        Assertions.assertEquals(1, makingFriendCircles.findCircleNum(input));
    }

    public int findCircleNum(int[][] M) {
        FriendCircle fc = new FriendCircle(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    fc.union(i, j);
                }
            }
        }
        return fc.circles;
    }
}
