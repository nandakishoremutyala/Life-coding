package dailycodings;

public class DailyCoding_512 {
    public static void main(String[] args) {

        DailyCoding_512 dailyCoding_512 = new DailyCoding_512();
        boolean result = dailyCoding_512.findEndPoint(new int[]{1, 3, 1, 2, 0, 1});
        System.out.println(result);

        boolean result1 = dailyCoding_512.findEndPoint(new int[]{1, 2, 1, 0, 0});
        System.out.println(result1);
    }

    public boolean findEndPoint(int[] in) {
        int target = in[in.length - 1];
        int start = 0;
        while (start <= target) {
            int next = in[start];
            if (next == target) return true;
            if (next < 0) return false;
            start = next;
            in[start] = -1;
        }

        return false;
    }
}
