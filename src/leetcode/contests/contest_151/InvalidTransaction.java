package leetcode.contests.contest_151;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class InvalidTransaction {
    class Transaction {
        String name;
        int timeInMin;
        int amount;
        String city;

        Transaction(String name, int timeInMin, int amount, String city) {
            this.name = name;
            this.timeInMin = timeInMin;
            this.amount = amount;
            this.city = city;
        }
    }

    InvalidTransaction invalidTransaction;

    @BeforeEach
    public void init() {
        invalidTransaction = new InvalidTransaction();
    }

    @Test
    public void firstTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"});
        for (String str : result) {
            System.out.println(str);
        }
    }

    @Test
    public void secondTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"});
        for (String str : result) {
            System.out.println(str);
        }
    }

    @Test
    public void thirdTest() {
        List<String> result = invalidTransaction.invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"});
        for (String str : result) {
            System.out.println(str);
        }
    }

    @Test
    public void fourthTest(){
        //["bob,656,1366,bangkok","alex,596,1390,amsterdam"]
        List<String> result =invalidTransaction.invalidTransactions(new String[]{"alex,676,260,bangkok",
                "bob,656,1366,bangkok",
                "alex,393,616,bangkok",
                "bob,820,990,amsterdam",
                "alex,596,1390,amsterdam"});
        for (String str : result) {
            System.out.println(str);
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        LinkedHashMap<String, List<Transaction>> nameToTransactionMap = new LinkedHashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] t = transactions[i].split(",");
            Transaction transaction = new Transaction(t[0],
                    Integer.parseInt(t[1]),
                    Integer.parseInt(t[2]),
                    t[3]);
            nameToTransactionMap.compute(t[0], (k, v) -> v == null ? new ArrayList<>() : v).add(transaction);
        }
        List<String> result = new ArrayList<>();
        Iterator<Map.Entry<String, List<Transaction>>> iterator;
        iterator = nameToTransactionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Transaction>> entry = iterator.next();
            List<String> invalidTransaction = findInvalid(entry.getValue());
            result.addAll(invalidTransaction);
        }
        return result;
    }

    private List<String> findInvalid(List<Transaction> transactions) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);

            if (t.amount > 1000) {
                addToString(t, temp);
            } else {
                if (i > 0 && Math.abs(t.timeInMin - transactions.get(i - 1).timeInMin) < 60){
                    addToString(transactions.get(i-1),temp);
                    addToString(t, temp);

                }
            }
        }
        return temp;
    }

    private void addToString(Transaction t, List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(t.name);
        sb.append(",");
        sb.append(t.timeInMin);
        sb.append(",");
        sb.append(t.amount);
        sb.append(",");
        sb.append(t.city);
        list.add(sb.toString());
    }
}
