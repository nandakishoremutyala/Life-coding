package leetcode.contests.contest_175;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TweetCounts {
    static TreeMap<Integer, HashMap<String, Integer>> map = new TreeMap<>();

    public TweetCounts() {

    }
    TweetCounts tweetCounts;
    @BeforeEach
    public void init(){
        tweetCounts=new TweetCounts();
    }

    @Test
    public void firstTest(){
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);
        System.out.println(map);

        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);

    }

    public void recordTweet(String tweetName, int time) {
        map.compute(time, (k, v) -> v == null ? new HashMap<>() : v)
                .compute(tweetName, (kk, vv) -> vv == null ? 1 : vv + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
return null;
    }

}
