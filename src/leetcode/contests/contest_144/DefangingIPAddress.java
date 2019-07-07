package leetcode.contests.contest_144;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefangingIPAddress {
    DefangingIPAddress mDefangingIPAddress;

    @BeforeEach
    public void init() {
        mDefangingIPAddress = new DefangingIPAddress();
    }

    @Test
    public void firstTest() {
        String input = "1.1.1.1";
        String expected = "1[.]1[.]1[.]1";
        String result = mDefangingIPAddress.defangIPaddr(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void secondTest() {
        String input = "255.100.50.0";
        String expected = "255[.]100[.]50[.]0";
        String result = mDefangingIPAddress.defangIPaddr(input);
        Assertions.assertEquals(expected, result);
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else
                sb.append(c);
        }
        return sb.toString();
    }
}
