package effort_2021;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinTransfers {
    public static void main(String[] args) {
        MinTransfers minTransfers=new MinTransfers();
        minTransfers.minTransfers(null);
    }
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<>();
        for (int[] transaction : transactions) {
            personToDebt.put(transaction[0], personToDebt.getOrDefault(transaction[0], 0) - transaction[2]);
            personToDebt.put(transaction[1], personToDebt.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        List<Integer> debts = personToDebt.values().stream().filter(d -> d != 0).collect(Collectors.toList());
        return dfs(debts, 0);
    }

    private int dfs(List<Integer> debts, int start) {
        while (start < debts.size() && debts.get(start) == 0) { // this person does not have any debt
            start++;
        }
        if (start == debts.size()) return 0; // nothing to process

        int ret = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            // one person has to be negative balance
            if (debts.get(start) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(start));
                ret = Math.min(ret, 1 + dfs(debts, start + 1));
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }
        return ret;
    }
}
