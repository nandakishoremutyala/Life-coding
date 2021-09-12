package leetcode.contests.contest_257;

import java.util.Arrays;
import java.util.HashMap;

public class FirstDayInAllTheRooms {
    public static void main(String[] args) {
        //firstDayBeenInAllRooms(new int[]{0, 0,2});

        firstDayBeenInAllRooms(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        HashMap<Integer, Integer> room = new HashMap<>();
        int n = nextVisit.length;
        int days = 0;
        int i = 0;

        while (room.size() != n) {
            room.put(i, room.getOrDefault(i, 0) + 1);
            if(room.size()==n) return days;
            int count = room.get(i);
            System.out.println(count);
            if ((count & 1) == 1) { //odd
                i = nextVisit[i];
            } else {
                i = (i + 1) % n;
            }
            days++;
        }
        System.out.println(days);
        return days - 1;
    }
}
