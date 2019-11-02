package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffer {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int localMinPrice = computePrice(price, needs);

        for (int i = pos; i < special.size(); i++) {
            List<Integer> s = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < s.get(j)) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - s.get(j));
            }
            if (temp != null) {
                localMinPrice = Math.min(localMinPrice, s.get(s.size() - 1) + helper(price, special, temp, i));
            }
        }
        return localMinPrice;
    }

    private int computePrice(List<Integer> price, List<Integer> needs) {
        int total = 0, i = 0;
        for (int n : needs) {
            total += n * price.get(i++);
        }
        return total;
    }
}
