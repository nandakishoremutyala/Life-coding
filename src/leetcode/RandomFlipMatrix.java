package leetcode;

import java.util.HashMap;
import java.util.Random;

public class RandomFlipMatrix {
    int row;
    int col;
    int total;

    HashMap<Integer, Integer> map;
    Random random;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        this.row = n_rows;
        this.col = n_cols;
        this.total = n_rows * n_cols;
        map = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        int num = random.nextInt(total--);
        int x = map.getOrDefault(num, num);
        map.put(num, map.getOrDefault(total, total));
        return new int[]{x / col, x % col};
    }

    public void reset() {
        map.clear();
        total=row*col;
    }
}
