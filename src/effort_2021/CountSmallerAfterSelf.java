package effort_2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CountSmallerAfterSelf {
    CountSmallerAfterSelf countSmallerAfterSelf;

    @BeforeEach
    public void init() {
        countSmallerAfterSelf = new CountSmallerAfterSelf();
    }

    @Test
    public void firstTest() {
        countSmallerAfterSelf.countSmaller(new int[]{5, 2, 6, 1});
    }

    @Test
    public void secondTest() {
        countSmallerAfterSelf.countSmaller(new int[]{-1, -1});
    }

    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000; // offset negative to non-negative
        int size = 2 * 10000 + 1; // total possible values in nums
        int[] tree = new int[size * 2];
        List<Integer> result = new ArrayList<Integer>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int smaller_count = query(0, nums[i] + offset, tree, size);
            result.add(smaller_count);
            update(nums[i] + offset, 1, tree, size);
        }
        Collections.reverse(result);
        return result;
    }

    public void update(int index, int value, int[] tree, int size) {
        index += size;
        tree[index] = tree[index] + value;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[2 * index + 1] + tree[2 * index];
        }
    }

    private int query(int left, int right, int[] tree, int size) {
        int result = 0;
        left += size;
        right += size;
        while (left < right) {
            if (left % 2 == 1) {
                result += tree[left];
                left++;
            }
            left /= 2;
            if (right % 2 == 1) {
                right--;
                result += tree[right];
            }
            right /= 2;
        }
        return result;
    }
}
