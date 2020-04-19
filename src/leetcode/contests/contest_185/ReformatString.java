package leetcode.contests.contest_185;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReformatString {
    ReformatString reformatString;

    @BeforeEach
    public void init() {
        reformatString = new ReformatString();
    }

    @Test
    public void firstTest() {
        String input = "a0b1c2";
        String output = reformatString.reformat(input);
        Assertions.assertEquals("0a1b2c",output);
    }


    @Test
    public void secondTest() {
        String input = "leetcode";
        String output = reformatString.reformat(input);
        Assertions.assertEquals("",output);
    }


    @Test
    public void thirdTest() {
        String input = "1229857369";
        String output = reformatString.reformat(input);
        Assertions.assertEquals("",output);
    }


    @Test
    public void fourthTest() {
        String input = "covid2019";
        String output = reformatString.reformat(input);
        Assertions.assertEquals("c2o0v1i9d",output);
    }


    @Test
    public void fifthTest() {
        String input = "ab123";
        String output = reformatString.reformat(input);
        Assertions.assertEquals("1a2b3",output);
    }

    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                numbers.add(c);
            else
                letters.add(c);
        }
        if (Math.abs(letters.size() - numbers.size()) > 1)
            return "";

        StringBuilder out = new StringBuilder();
        int i = 0, j = 0;
        boolean flagChar = false;
        if(letters.size()>numbers.size())
            flagChar=true;

        while (i < numbers.size() && j < letters.size()) {
            if (flagChar) {
                out.append(letters.get(j));
                j++;
                flagChar = false;
            } else {
                out.append(numbers.get(i));
                i++;
                flagChar = true;
            }
        }
        if (i < numbers.size())
            out.append(numbers.get(i));

        if (j < letters.size())
            out.append(letters.get(j));

        return out.toString();
    }
}
