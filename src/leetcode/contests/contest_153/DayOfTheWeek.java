package leetcode.contests.contest_153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class DayOfTheWeek {
    DayOfTheWeek dayOfTheWeek;

    @BeforeEach
    public void init() {
        dayOfTheWeek = new DayOfTheWeek();
    }

    @Test
    public void firstTest() {
        String output = dayOfTheWeek.dayOfTheWeek(31, 8, 2019);
        Assertions.assertEquals("Saturday", output);
    }

    //count all the days from 1971
    // add 3 since start from monday
    // %7
    public String dayOfTheWeek(int day, int month, int year) {

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        String[] days_of_week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
                "Sunday"};

        for (int i = 1971; i < year; i++) {

            if (isleapyear(i)) {
                days = days + 1;
            }
            days = days + 365;
        }

        for (int i = 1; i < month; i++) {
            if (i == 2 && isleapyear(year)) {
                days = days + 1;
            }

            days = days + months[i];
        }

        days = days + day;

        return days_of_week[(3 + days) % 7];
    }

    static boolean isleapyear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
