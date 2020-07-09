package practice;

import javafx.util.Pair;

import java.util.LinkedList;

public class SlidingWindowMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 7, 2, 4, 2};
        LinkedList<Pair> pq = new LinkedList<>();
        int k = 3;

        for (int i = 0; i < arr.length; i++) {
            while (!pq.isEmpty() &&
                    (int) pq.getLast().getKey() >= arr[i]) {
                pq.removeLast();
            }
            pq.addLast(new Pair(arr[i], i));

            while ((int) pq.getFirst().getValue() <= i - k) {
                pq.removeFirst();
            }
            System.out.println((int) pq.getFirst().getKey());
        }
    }
}
