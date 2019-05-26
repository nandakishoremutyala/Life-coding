package leetcode.contests.contest_138;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DistantBarcode {
    DistantBarcode distantBarcode;

    @BeforeEach
    public void inti() {
        distantBarcode = new DistantBarcode();
    }

    @Test
    public void testFirst() {
        int[] expected = distantBarcode.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
        Assertions.assertArrayEquals(new int[]{1, 3, 1, 3, 1, 2, 1, 2}, expected);
    }

    @Test
    public void testSecond() {
        int[] expected = distantBarcode.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2});
        Assertions.assertArrayEquals(new int[]{1, 2, 1, 2, 1, 2}, expected);
    }

    @Test
    public void testThird() {
        int[] expected = distantBarcode.rearrangeBarcodes(new int[]{2, 2, 2, 1, 5});
        Assertions.assertArrayEquals(new int[]{2, 5, 2, 1, 2}, expected);
    }

    @Test
    public void testFourth() {
        distantBarcode.rearrangeBarcodes(new int[]{7, 7, 7, 8, 5, 7, 5, 5, 5, 8});
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(barcodes);
        for (int i = barcodes.length - 1; i >= 0; i--) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }
        // Here using the priority queue to sort the map with highest value first
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int idx = 0;
        Arrays.fill(barcodes, -1);
        while (!pq.isEmpty()) {
            Map.Entry m = pq.poll();
            int key = (int) m.getKey();
            int val = (int) m.getValue();
            int j = val;
            while (j > 0) {
                if (barcodes[idx] == -1) {
                    barcodes[idx] = key;
                    idx = idx + 2;
                    j--;
                } else {
                    idx++;
                }
                if (idx >= barcodes.length) {
                    idx = 0;
                }
            }
        }
        return barcodes;
    }
}
