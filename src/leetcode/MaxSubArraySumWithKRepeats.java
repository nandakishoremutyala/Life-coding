package leetcode;

public class MaxSubArraySumWithKRepeats {
    static void arrayConcatenate(int arr[], int b[],
                                 int k) {
        // Array b will be formed by concatenation
        // array a exactly k times
        int j = 0;
        while (k > 0) {
            for (int i = 0; i < arr.length; i++) {
                b[j++] = arr[i];
            }
            k--;
        }
    }

    // Function to return the maximum
    // subarray sum of arr[]
    static int maxSubArrSum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    // Function to return the maximum sub-array
    // sum of the modified array
    static long maxSubKSum(int arr[], int k) {
        int arrSum = 0;
        long maxSubArrSum = 0;

        int b[] = new int[(2 * arr.length)];

        // Concatenating the array 2 times
        arrayConcatenate(arr, b, 2);

        // Finding the sum of the array
        for (int i = 0; i < arr.length; i++)
            arrSum += arr[i];

        // If sum is less than zero
        if (arrSum < 0)
            maxSubArrSum = maxSubArrSum(b);

            // If sum is greater than zero
        else
            maxSubArrSum = maxSubArrSum(b) +
                    (k - 2) * arrSum;

        return maxSubArrSum;
    }

}
