package leetcode.contests.contest_290;

public class NumberOfFlowersFullBlown {

public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int max = 0;

        for (int[] flower : flowers) {
            max = Math.max(flower[1], max);
        }
        for (int i : persons) {
            max = Math.max(max, i);
        }
        int[] diffArr = new int[max + 2];

        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1] + 1;
            diffArr[start] += 1;
            diffArr[end] -= 1;
        }

        int n = diffArr.length;
        int[] seg = new int[n * 2];

        for (int j = 0; j < n; j++)
            seg[n + j] = diffArr[j];

        int t = n - 1;
        for (int i = n - 1; i >= 1; i--) {
            seg[i] = seg[2 * i] + seg[(2 * i) + 1];
        }
        int[] result = new int[persons.length];
        int idx = 0;
        for (int i : persons) {
            int res = query(seg, 0, i, n + 1);
            result[idx++] = res;
        }
        return result;

    }

    public int query(int[] tree, int left, int right, int n) {
        // since actual data is in the right side
        // left = left + n;
        //right = right + n;
        int result = 0;
        for (left = left + n, right = right + n; left < right; left >>= 1, right >>= 1) {

            if ((left & 1) > 0) {// AND operations with 1 gives 0 for even number and 1 for odd number
                result += tree[left++];
            }
            if ((right & 1) > 0) {
                result += tree[--right];
            }
        }
        return result;
    }
}
