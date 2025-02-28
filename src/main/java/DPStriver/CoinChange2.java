package DPStriver;

import java.util.*;
class CoinChange2 {

    //memoization technique
    public static long solve(int ind, int[] coins, int amount, long[][] dp)
    {
        if(ind == 0)
            return (amount % coins[ind] == 0) ? 1 : 0;


        if(dp[ind][amount] != -1)
            return dp[ind][amount];

        long notTake = 0+solve(ind-1, coins, amount, dp);
        long take = 0;
        if(coins[ind]<=amount)
            take = solve(ind, coins, amount-coins[ind], dp);

        return dp[ind][amount] = notTake + take;

    }

    public static long countWaysToMakeChange(int coins[], int amount){
        //write your code here		
        //tabulation with space optimization	
        int n = coins.length;
        long prev[] = new long[amount+1];
        long curr[] = new long[amount+1];

        for(int i =0;i<=amount;i++)
            prev[i]=(i % coins[0] == 0)?1:0;
        for(int ind =1;ind<n;ind++)
        {
            for(int j = 0;j<=amount;j++)
            {
                long notTake = 0+prev[j];
                long take = 0;
                if(coins[ind]<=j)
                    take = curr[j-coins[ind]];
                curr[j] = notTake + take;
            }
            prev = curr;
        }
        return prev[amount];
    }

    public static void main(String[] args) {
        long minCountWays = countWaysToMakeChange(new int[]{1,2,3,4}, 5);
        System.out.println("minCountWays = " + minCountWays);
        
    }

}