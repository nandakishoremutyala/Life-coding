package leetcode.contests.contest_182;

import java.util.*;

public class UndergroundSystem {
    private class Transaction {
        int id;
        String stationName;
        int time;

        public Transaction(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    HashMap<Integer, Transaction> userCheckIn = new HashMap<>();
    HashMap<Integer, Transaction> userCheckOut = new HashMap<>();
    HashMap<String, Set<Integer>> gates = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Transaction transaction = new Transaction(id, stationName, t);
        userCheckIn.put(id, transaction);
        gates.compute(stationName, (k, v) -> v == null ? new HashSet<>() : v).add(id);
    }

    public void checkOut(int id, String stationName, int t) {
        Transaction transaction = new Transaction(id, stationName, t);
        userCheckOut.put(id, transaction);
        gates.compute(stationName, (k, v) -> v == null ? new HashSet<>() : v).add(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Set<Integer> start = gates.get(startStation);
        Set<Integer> end = gates.get(endStation);

        Iterator<Integer> it = start.iterator();
        int n=0;
        double total=0;
        while (it.hasNext()){
            Integer x = it.next();
            if(end.contains(x)){
                int e = userCheckOut.get(x).getTime();
                int s = userCheckIn.get(x).getTime();
                assert e>s;
                total+=(e-s);
                n+=1;
            }

        }
        return total/n;
    }
}
