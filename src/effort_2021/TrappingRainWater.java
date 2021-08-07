package effort_2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrappingRainWater {
    TrappingRainWater trappingRainWater;

    @BeforeEach
    public void init() {
        trappingRainWater = new TrappingRainWater();
    }

    @Test
    public void firstTest() {
        trappingRainWater.trap(new int[]{4, 2, 0, 3, 2, 5});
    }

    public int trap(int[] height) {
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int res = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= lMax) {
                    lMax = height[l];
                } else {
                    res += lMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rMax) {
                    rMax = height[r];
                } else {
                    res += rMax - height[r];
                }
                r--;
            }
        }
        return res;
    }

    @Test
    public void firstTest1() {
        int res = trappingRainWater.trap1(new int[]{4, 2, 0, 3, 2, 5});
        Assertions.assertEquals(res, 9);
    }

    @Test
    public void secondTest1() {
        int res = trappingRainWater.trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assertions.assertEquals(res, 6);
    }

    public int trap1(int[] height) {
        int leftMax = 0;
        int rightMax = height[height.length - 1];
        int total = 0;
        int l = 0;
        int r = height.length - 1;
        int curr = 0;

        while (l < r) {
            int wall = Math.min(leftMax, rightMax);
            if (height[curr] < wall) {
                total += (wall - height[curr]);
            }
            leftMax = Math.max(leftMax, height[curr]);
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
            curr++;
        }
        return total;
    }
}
