package leetcode.contests.contest_144;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CorporateFlightBookings {

    CorporateFlightBookings mCorporateFlightBookings;

    @BeforeEach
    public void init() {
        mCorporateFlightBookings = new CorporateFlightBookings();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] expected = new int[]{10, 55, 45, 25, 25};
        int[] actual = mCorporateFlightBookings.corpFlightBookings(input, n);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        int[][] input = new int[][]{{2, 2, 30}, {2, 2, 45}};
        int n = 2;
        int[] expected = new int[]{0, 75};
        int[] actual = mCorporateFlightBookings.corpFlightBookings(input, n);
        Assertions.assertArrayEquals(expected, actual);
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (n == 0) return new int[0];
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            for (int j = start; j <= end; j++) {
                result[j - 1] = result[j - 1] + seats;
            }
        }
        return result;
    }
}
