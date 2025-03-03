package DPStriver;

public class BuySellStocks3 {
    public static int solve(int ind, int[] prices, int buy, int[][][]dp, int cap)
    {
        if(ind==prices.length || cap ==0)
            return 0;

        int profit = 0;

        if(dp[ind][buy][cap]!=-1)
            return dp[ind][buy][cap];
        if(buy==1)
        {
            profit = Math.max(-prices[ind] +  solve(ind+1, prices, 0, dp,cap), 0 + solve(ind+1, prices, 1, dp, cap));
        }
        else
        {
            profit = Math.max(prices[ind] +  solve(ind+1, prices, 1, dp, cap-1), 0 + solve(ind+1, prices, 0, dp, cap));

        }

        return dp[ind][buy][cap] = profit;
    }
    public static int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        //  for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //    }
        //  }
        // return solve(0, prices, 1, dp, 2);

        int n = prices.length;

        // Create a 2D array 'ahead' and 'cur' to store profit values
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        // Loop through the prices array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }

            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }

        // The maximum profit with 2 transactions is stored in ahead[0][2]
        return ahead[0][2];


    }

    public static void main(String[] args) {

        int maxProfit = maxProfit(new int[]{3,3,5,0,0,3,1,4});
        System.out.println("maxProfit = " + maxProfit);
    }
}
