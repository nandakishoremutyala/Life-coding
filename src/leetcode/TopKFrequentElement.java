package leetcode;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {

        TopKFrequentElement topKFrequentElement=new TopKFrequentElement();
        List<Integer> result= topKFrequentElement.topKFrequent(new int[]{1,1,1,2,2,3},2);
        for (int val:result){
            System.out.print(val);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i : nums) {
            counter.compute(i, (key, v) -> v == null ? 1 : v + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e2.getValue() > e1.getValue()) return 1;
            else if (e1.getValue() > e2.getValue()) return -1;
            else return 0;
        });

        for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
            pq.add(e);
        }
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && i < k) {
            result.add(pq.poll().getKey());
            i++;
        }

        return result;
    }
}
