package DPStriver;

public class BuySellStocks1 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for(int i =1;i<prices.length;i++)
        {
            int currentCost = prices[i]-minPrice;
            profit = Math.max(currentCost, profit);
            minPrice = Math.min(prices[i], minPrice);
        }

        return profit;
    }

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("maxProfit = " + maxProfit);
    }
}
