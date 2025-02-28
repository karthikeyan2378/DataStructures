package DPStriver;

import java.util.Arrays;

class CoinChange1 {
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;

        for(int coin: coins)
            for(int j =coin;j<=amount;j++)
                dp[j]= Math.min(dp[j], 1+dp[j-coin]);

        return (dp[amount] == amount + 1) ? -1 : dp[amount]; // If no solution, return -1
        
    }

    public static void main(String[] args) {
        int min = coinChange(new int[]{1,2,5}, 11);
        System.out.println("min = " + min);
    }
}