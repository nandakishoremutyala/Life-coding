package prep_2021.geeksforgeeks.dp;
/**
 * Problem Statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Explanation of the solution:
 * Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
 * Then the tricky part comes, how to handle the twoBuy? Suppose in real life, you have bought and sold a stock and made $100 dollar profit.
 * When you want to purchase a stock which costs you $300 dollars, how would you think this? You must think, um, I have made $100 profit,
 * so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
 * There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!! The twoBuyTwoSell is just
 * making as much profit as possible.
 * Hope this explanation helps other people to understand this!
 *
 * */
public class BuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int oneBuy=Integer.MAX_VALUE;
        int oneBuyOneSell=0;
        int secondBuy= Integer.MAX_VALUE;
        int secondBuySecondSell=0;

        for(int i=0;i<prices.length;i++){
            int p=prices[i];
            oneBuy=Math.min(oneBuy,p);
            oneBuyOneSell=Math.max(oneBuyOneSell,(p-oneBuy));

            secondBuy=Math.min(secondBuy,p-oneBuyOneSell);
            secondBuySecondSell=Math.max(secondBuySecondSell,p-secondBuy);
        }
        return secondBuySecondSell;
    }
}
