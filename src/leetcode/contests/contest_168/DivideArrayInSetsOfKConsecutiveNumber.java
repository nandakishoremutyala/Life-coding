package leetcode.contests.contest_168;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.Arrays;
import java.util.LinkedList;

public class DivideArrayInSetsOfKConsecutiveNumber {
    DivideArrayInSetsOfKConsecutiveNumber divideArrayInSetsOfKConsecutiveNumber;

    @BeforeEach
    public void init() {
        divideArrayInSetsOfKConsecutiveNumber = new DivideArrayInSetsOfKConsecutiveNumber();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
        int k = 4;
        boolean result = divideArrayInSetsOfKConsecutiveNumber
                .isPossibleDivide(input, k);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;
        boolean result = divideArrayInSetsOfKConsecutiveNumber
                .isPossibleDivide(input, k);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void thirdTest() {
        int[] input = new int[]{3, 3, 2, 2, 1, 1};
        int k = 3;
        boolean result = divideArrayInSetsOfKConsecutiveNumber
                .isPossibleDivide(input, k);
        Assertions.assertEquals(true, result);
    }

    @Test
    public void fourthTest() {
        int[] input = new int[]{1, 2, 3, 4};
        int k = 3;
        boolean result = divideArrayInSetsOfKConsecutiveNumber
                .isPossibleDivide(input, k);
        Assertions.assertEquals(false, result);
    }

    @Test
    public void fifthTest() {
        int[] input = new int[]{12, 12, 2, 11, 22, 20, 11, 13, 3, 21, 1, 13};
        int k = 3;
        boolean result = divideArrayInSetsOfKConsecutiveNumber
                .isPossibleDivide(input, k);
        Assertions.assertEquals(true, result);
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        LinkedList<Integer>[] data = new LinkedList[nums.length / k];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
        for (int val : nums) {
            insert(data, val, k);
        }
        System.out.println(data);
        for (LinkedList list : data) {
            MasterPrinter.printList(list);
            if (list.size() != k) return false;
        }
        return true;
    }


    private void insert(LinkedList<Integer>[] data, int val, int k) {
        for (LinkedList list : data) {
            if (list.size() == 0) {
                list.add(val);
                break;
            }
            if (list.size() < k) {
                if (((int) list.getFirst() - val) == 1) {
                    list.addFirst(val);
                    break;
                } else if ((val - (int) list.getLast()) == 1) {
                    list.addLast(val);
                    break;
                }
            }
        }
    }
}
