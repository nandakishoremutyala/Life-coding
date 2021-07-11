package prep_2021.epj;

import java.util.List;

public class MaxProfitPage50 {
    public static double computeMaxProfit(List<Double> prices){
        double minPrice=Double.MAX_VALUE, maxProfit=0.0;

        for(Double price:prices){
            maxProfit=Math.max(maxProfit,price-minPrice);
            minPrice=Math.min(minPrice,price);
        }
        return maxProfit;
    }
}
