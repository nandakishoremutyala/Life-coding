package leetcode.contests.contest_142;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CarPooling {
    CarPooling carPooling;
    static int mCapacity;

    class Trip {
        int passengers;
        int start_loc;
        int end_location;

        public Trip(int passengers, int start_loc, int end_location) {
            this.passengers = passengers;
            this.start_loc = start_loc;
            this.end_location = end_location;
        }

        public int getPassangers() {
            return passengers;
        }

        public int getStart_loc() {
            return start_loc;
        }

        public int getEnd_location() {
            return end_location;
        }
    }

    @BeforeEach
    public void init() {
        carPooling = new CarPooling();
    }

    @Test
    public void firstTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{3, 2, 7},
                {3, 7, 9}, {8, 3, 9}}, 11);
        Assertions.assertEquals(true, isPossible);
    }

    @Test
    public void secondTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{2, 1, 5},
                {3, 3, 7}}, 5);
        Assertions.assertEquals(true, isPossible);
    }

    @Test
    public void thirdTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{2, 1, 5},
                {3, 3, 7}}, 4);
        Assertions.assertEquals(false, isPossible);
    }

    @Test
    public void fourthTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{2, 1, 5},
                {3, 5, 7}}, 3);
        Assertions.assertEquals(true, isPossible);
    }

    @Test
    public void fifthTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{3, 2, 8},
                {4, 4, 6}, {10, 8, 9}}, 11);
        Assertions.assertEquals(true, isPossible);
    }

    @Test
    public void sixthTest() {
        boolean isPossible = carPooling.carPooling(new int[][]{{4, 3, 4},
                {3, 2, 4}, {1, 8, 9}, {7, 2, 5}}, 14);
        Assertions.assertEquals(true, isPossible);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        mCapacity = capacity;
        // Sort the trip based on start location
        ArrayList<Trip> tripList = new ArrayList<>();
        for (int i = 0; i < trips.length; i++) {
            int[] t = trips[i];
            tripList.add(new Trip(t[0], t[1], t[2]));
        }

        Collections.sort(tripList, (t1, t2) -> {
            if (t1.start_loc > t2.start_loc) return 1;
            else if (t1.start_loc < t2.start_loc) return -1;
            else return 0;
        });

        // monitor, how many people will be dropped in what location
        TreeMap<Integer, Integer> downPassengers = new TreeMap<>();
        for (int i = 0; i < trips.length; i++) {
            Trip trip = tripList.get(i);
            // whenever a new station comes, you already dropped all the passenger before this location
            dropAllPassengerBefore(trip.getStart_loc(), downPassengers);
            if (trip.getPassangers() > mCapacity)
                return false;
            else {
                downPassengers.compute(trip.getEnd_location(),
                        (k, v) -> v == null ? trip.getPassangers() : v + trip.getPassangers());
                mCapacity -= trip.getPassangers();
            }
        }
        return true;

    }

    private void dropAllPassengerBefore(int start_loc,
                                        TreeMap<Integer, Integer> downPassengers) {
        Iterator<Map.Entry<Integer, Integer>> it = downPassengers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getKey() <= start_loc) {
                mCapacity += entry.getValue();
                it.remove();

            } else {
                break;
            }
        }

    }
}
