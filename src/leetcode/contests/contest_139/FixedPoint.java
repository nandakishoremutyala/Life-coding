package leetcode.contests.contest_139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FixedPoint {
    FixedPoint fixedPoint;

    @BeforeEach
    public void init() {
        fixedPoint = new FixedPoint();
    }

    @Test
    public void simpleTest(){
        Assertions.assertEquals(-1,fixedPoint.fixedPoint(new int[]{-10,-5,3,4,7,9}));
    }

    public int fixedPoint(int[] A) {
        int start = 0;
        int end = A.length;
        return binarySearch(A, start, end);
    }

    int binarySearch(int arr[], int l, int r) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (arr[mid] == mid)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > mid)
                return binarySearch(arr, l, mid - 1);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }
}
