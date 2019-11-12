package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareVersionNumbers {
    CompareVersionNumbers compareVersionNumbers;

    @BeforeEach
    public void init() {
        compareVersionNumbers = new CompareVersionNumbers();
    }

    @Test
    public void firstTest() {
        int result = compareVersionNumbers.compareVersion("0.1", "1.1");
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void secondTest() {
        int result = compareVersionNumbers.compareVersion("1.0.1", "1");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void thirdTest() {
        int result = compareVersionNumbers.compareVersion("7.5.2.4", "7.5.3");
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void fourthTest() {
        int result = compareVersionNumbers.compareVersion("1.01", "1.001");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void fifthTest() {
        int result = compareVersionNumbers.compareVersion("1.0", "1.0.0");
        Assertions.assertEquals(0, result);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (String str : v1)
            System.out.println(Integer.parseInt(str));


        for (String str : v2)
            System.out.println(Integer.parseInt(str));

        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[j]);
            if (a > b) return 1;
            else if (a < b) return -1;
            i++;
            j++;
        }

        if (i == v1.length && j == v2.length) return 0;

        else if (i < v1.length && j == v2.length) {
            int k = i;
            while (k < v1.length) {
                if (Integer.parseInt(v1[k]) > 0) return 1;
                k++;
            }
        } else if (i == v1.length && j < v2.length) {
            int k = j;
            while (k < v2.length) {
                if (Integer.parseInt(v2[k]) > 0) return -1;
                k++;
            }
        }
        return 0;
    }

}
