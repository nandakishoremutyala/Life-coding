package leetcode.contests.contest_151;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class InvalidTransaction {
    class Transaction {
        String name;
        int timeInMin;
        int amount;
        String city;
        boolean addedToInvalid;

        Transaction(String name, int timeInMin, int amount, String city) {
            this.name = name;
            this.timeInMin = timeInMin;
            this.amount = amount;
            this.city = city;
            this.addedToInvalid = amount > 1000;
        }
    }

    InvalidTransaction invalidTransaction;

    @BeforeEach
    public void init() {
        invalidTransaction = new InvalidTransaction();
    }

    @Test
    public void firstTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "alice,20,800,mtv",
                "alice,50,100,beijing"});
        Assertions.assertLinesMatch(Arrays.asList(
                "alice,20,800,mtv",
                "alice,50,100,beijing"), result);
    }

    @Test
    public void secondTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "alice,20,800,mtv",
                "alice,50,1200,mtv"});
        Assertions.assertLinesMatch(Arrays.asList("alice,50,1200,mtv"), result);
    }

    @Test
    public void thirdTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "alice,20,800,mtv",
                "bob,50,1200,mtv"});
        Assertions.assertLinesMatch(Arrays.asList("bob,50,1200,mtv"), result);
    }

    @Test
    public void fourthTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "alex,676,260,bangkok",
                "bob,656,1366,bangkok",
                "alex,393,616,bangkok",
                "bob,820,990,amsterdam",
                "alex,596,1390,amsterdam"});
        Assertions.assertLinesMatch(Arrays.asList(
                "bob,656,1366,bangkok",
                "alex,596,1390,amsterdam"), result);
    }

    @Test
    public void fifthTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "bob,689,1910,barcelona",
                "alex,696,122,bangkok",
                "bob,832,1726,barcelona",
                "bob,820,596,bangkok",
                "chalicefy,217,669,barcelona",
                "bob,175,221,amsterdam"});
        Assertions.assertLinesMatch(Arrays.asList(
                "bob,689,1910,barcelona",
                "bob,832,1726,barcelona",
                "bob,820,596,bangkok"), result);
    }

    @Test
    public void sixthTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{
                "bob,627,1973,amsterdam",
                "alex,387,885,bangkok",
                "alex,355,1029,barcelona",
                "alex,587,402,bangkok",
                "chalicefy,973,830,barcelona",
                "alex,932,86,bangkok",
                "bob,188,989,amsterdam"});
        Assertions.assertLinesMatch(Arrays.asList(
                "bob,627,1973,amsterdam",
                "alex,387,885,bangkok",
                "alex,355,1029,barcelona"), result);
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] t = new Transaction[n];
        for (int i = 0; i < n; i++) {
            String[] values = transactions[i].split(",");
            t[i] = new Transaction(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3]);
        }
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i].name.equals(t[j].name) &&
                        Math.abs(t[i].timeInMin - t[j].timeInMin) <= 60 &&
                        !t[i].city.equals(t[j].city)) {
                    t[i].addedToInvalid = true;
                    t[j].addedToInvalid = true;
                }
            }
        }
        List<String> inValidTransactions = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i].addedToInvalid) {
                inValidTransactions.add(transactions[i]);
            }
        }
        return inValidTransactions;
    }
}
