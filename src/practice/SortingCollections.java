package practice;

import java.util.ArrayList;
import java.util.Comparator;

public class SortingCollections {
    private static class Inerval {
        int start;
        int end;

        public Inerval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        ArrayList<Inerval> list = new ArrayList<>();
        list.add(new Inerval(1, 3));
        list.add(new Inerval(5, 8));
        list.add(new Inerval(4, 10));
        list.add(new Inerval(20, 25));
        list.sort(Comparator.comparingInt(v -> v.start));
        list.stream().forEach(interval -> {
            System.out.println(interval.start + "->" + interval.end);
        });

        // How to sort this from bigger to smaller

        list.sort((i1, i2) -> {
            if (i2.start > i1.start) return 1;
            else if (i1.start > i2.start) return -1;
            else return 0;

        });

        list.stream().forEach(interval -> {
            System.out.println(interval.start + "->" + interval.end);
        });
    }
}
