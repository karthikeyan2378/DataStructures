package DPStriver;

import java.util.Arrays;

public class BuySellStocks5 {
    public static int solve(int ind, int[] prices, int buy, int[][]dp)
    {
        if(ind>=prices.length)
            return 0;

        int profit = 0;

        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        if(buy==1)
        {
            profit = Math.max(-prices[ind] +  solve(ind+1, prices, 0, dp), 0 + solve(ind+1, prices, 1, dp));
        }
        else
        {
            profit = Math.max(prices[ind] +  solve(ind+2, prices, 1, dp), 0 + solve(ind+1, prices, 0, dp));

        }

        return dp[ind][buy] = profit;
    }

    public static  int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2]; // because 1 for buy and another for sell
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, prices, 1, dp);

    }

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{1,2,3,0,2});
        System.out.println("maxProfit = " + maxProfit);
    }
}
