package leetcode.contests.contest_181;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CreateTargetArrayInGivenOrder {
    CreateTargetArrayInGivenOrder createTargetArrayInGivenOrder;

    @BeforeEach
    public void init() {
        createTargetArrayInGivenOrder = new CreateTargetArrayInGivenOrder();
    }

    @Test
    public void firstTest() {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        int[] target = new int[]{0, 4, 1, 3, 2};
        int[] result = createTargetArrayInGivenOrder.createTargetArray(nums, index);
        Assertions.assertArrayEquals(result, target);
    }

    @Test
    public void secondTest() {
        int[] nums = new int[]{1, 2, 3, 4, 0};
        int[] index = new int[]{0, 1, 2, 3, 0};
        int[] target = new int[]{0, 1, 2, 3, 4};
        int[] result = createTargetArrayInGivenOrder.createTargetArray(nums, index);
        Assertions.assertArrayEquals(result, target);
    }

    @Test
    public void thirdTest() {
        int[] nums = new int[]{1};
        int[] index = new int[]{0};
        int[] target = new int[]{1};
        int[] result = createTargetArrayInGivenOrder.createTargetArray(nums, index);
        Assertions.assertArrayEquals(result, target);
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = index[i];
            list = moveAndAttach(pos, list, nums[i]);
        }
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    private List<Integer> moveAndAttach(int move, List<Integer> list, int val) {
        List<Integer> result = new ArrayList<>();
        if (list.size() == 0) result.add(val);
        else if (move > list.size()) {
            list.add(list.size(), val);
            result.addAll(list);
        } else {
            List<Integer> head = new ArrayList<>(list.subList(0, move));
            List<Integer> tail = new ArrayList<>(list.subList(move, list.size()));
            head.add(val);
            result.addAll(head);
            result.addAll(tail);
        }
        return result;
    }
}
