package leetcode;

import others.MasterPrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {
    public static void main(String[] args) {

        PrisonCellAfterNDays prisonCellAfterNDays = new PrisonCellAfterNDays();
        prisonCellAfterNDays.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
    }

    /**
     * 0ld: 0 new: -1 occupied to occup
     * old: 1  new: 2 occup to 0ccup
     * <p>
     * old:1 new: 3; occup to vacant
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; ++i) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            // we are trying to look for the repeat when a repeat happens
            // subtraction gives us the cycles needed to repeat
            // division will find the rest of the N
            if (seen.containsKey(Arrays.toString(cells)))
                N %= seen.get(Arrays.toString(cells)) - N;
        }
        return cells;
    }
}
