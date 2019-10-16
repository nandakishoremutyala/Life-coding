package graph.union_find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MakingFriendCircles {
    MakingFriendCircles makingFriendCircles;

    class FriendCircle {
       // int students;
        int[] friends;
        int[] ranks;
        int circles;

        FriendCircle(int num) {
            //this.students = num;
            this.circles=num;
            this.friends = new int[num];
            this.ranks=new int[num];
            for (int i = 0; i < num; i++) {
                friends[i] = i;
                ranks[i]=1;
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
                    ranks[rootY]+= ranks[rootX];
                    friends[rootX] = rootY;
                } else {
                    ranks[rootX]+= ranks[rootY];
                    friends[rootY] = rootX;
                }
                circles--;
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
        FriendCircle fc=new FriendCircle(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(M[i][j]==1){
                    int std1=i;
                    int std2=j;
                    fc.union(std1,std2);
                    fc.circles--;
                }
            }
        }

        System.out.println(fc.friends);
        return fc.circles;
    }
}
