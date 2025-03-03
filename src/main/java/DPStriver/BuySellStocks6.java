package DPStriver;

import java.util.Arrays;

public class BuySellStocks6 {
    public static int solve(int ind, int[] prices, int buy, int[][]dp, int fee)
    {
        if(ind==prices.length)
            return 0;

        int profit = 0;

        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        if(buy==1)
        {
            profit = Math.max(-prices[ind] +  solve(ind+1, prices, 0, dp, fee), 0 + solve(ind+1, prices, 1, dp, fee));
        }
        else
        {
            profit = Math.max(prices[ind]-fee +  solve(ind+1, prices, 1, dp, fee), 0 + solve(ind+1, prices, 0, dp, fee));

        }

        return dp[ind][buy] = profit;
    }
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2]; // because 1 for buy and another for sell
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, prices, 1, dp, fee);
    }

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{1,3,2,8,4,9}, 2);
        System.out.println("maxProfit = " + maxProfit);
    }
}
