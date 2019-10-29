package leetcode;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> result = topKFrequentWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},
                2);
        for (String s:result) System.out.println(s);
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            answer.add(pq.poll());
        }
        return answer;
    }
}
