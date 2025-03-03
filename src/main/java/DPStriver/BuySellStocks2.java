package DPStriver;

public class BuySellStocks2 {
    public static int solve(int ind, int[] prices, int buy, int[][]dp)
    {
        if(ind==prices.length)
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
            profit = Math.max(prices[ind] +  solve(ind+1, prices, 1, dp), 0 + solve(ind+1, prices, 0, dp));

        }

        return dp[ind][buy] = profit;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        //int dp[][] = new int[n][2]; // because 1 for buy and another for sell
        // for(int[] row : dp)
        // Arrays.fill(row, -1);

        //int dp[][]= new int[n+1][2]; // for tabulation use n+1;

        int ahead[] = new int[2];
        int curr[]= new int[2];


// Base condition: If we have no stocks to buy or sell, profit is 0
        // dp[n][0] = dp[n][1] = 0;

        ahead[0] = ahead[1]=0;
        int profit = 0;

        for(int ind = n-1;ind>=0;ind--)
        {
            for(int buy = 0;buy<=1;buy++)
            {
                if(buy==1)
                {
                    // profit = Math.max(-prices[ind] +  dp[ind+1][0],  0 + dp[ind+1][1]);
                    profit = Math.max(-prices[ind] +  ahead[0],  0 +ahead[1]);
                }
                else
                {
                    //profit = Math.max(prices[ind] + dp[ind+1][1], 0 + dp[ind+1][0]);
                    profit = Math.max(prices[ind] + ahead[1], 0 + ahead[0]);


                }
                // dp[ind][buy]= profit;
                curr[buy]= profit;
            }
            System.arraycopy(curr, 0, ahead, 0, 2);
        }
        // return dp[0][1];
        return curr[1];
    }

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("maxProfit = " + maxProfit);
    }
}
