package leetcode.contests.contest_177;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class NumberOfDaysBetweenTwoDays {
    public int daysBetweenDates(String date1, String date2) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        long noOfDaysBetween = DAYS.between(startDate, endDate);
        return Math.abs((int) noOfDaysBetween);
    }
}
