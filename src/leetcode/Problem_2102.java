package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_2102 {

    PriorityQueue<Pair> minQ;
    PriorityQueue<Pair> maxQ;

    int counter = 0;

    public static void main(String[] args) {
        Problem_2102 p = new Problem_2102();
        p.add("bradford", 2);
        p.add("branford", 3);
        System.out.println(p.get());
        p.add("alps", 2);
        System.out.println(p.get());
        p.add("orland", 2);
        System.out.println(p.get());
    }

    public Problem_2102() {
        this.maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        this.minQ = new PriorityQueue<Pair>();
    }

    public void add(String name, int score) {
        minQ.add(new Pair(score, name));
        maxQ.add(minQ.poll());
    }

    public String get() {
        Pair pair = maxQ.poll();
        minQ.add(pair);
        return pair.name;
    }
}

  class Pair implements Comparable<Pair> {
    int score;
    String name;

    Pair(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.score == o.score)
            return o.name.compareTo(this.name);
        return this.score - o.score;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
