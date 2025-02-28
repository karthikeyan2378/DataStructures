package DPStriver;

import java.util.*;
class RodCuttingDP {

    public static int solve(int ind, int n, int price[], int[][] dp)
    {
        if(ind==0)
            return n*price[0];

        if(dp[ind][n] != -1)
            return dp[ind][n];
        int notTake = 0+ solve(ind-1, n, price, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind+1;
        if(rodLength<=n)
            take = price[ind]+solve(ind, n-rodLength, price, dp);

        return dp[ind][n] =  Math.max(take, notTake);

    }
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int length =  price.length;

        int prev[] = new int[n+1];



        for(int i =0;i<=n;i++)
            prev[i] = i*price[0];

        for(int ind =1;ind<length;ind++)
        {
            for(int val =0;val<=n;val++)
            {
                int notTake = 0+ prev[val];
                int take = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength<=val)
                    take = price[ind]+prev[val-rodLength];
                prev[val] =  Math.max(take, notTake);
            }
        }
        return prev[n];
    }

    public static void main(String[] args) {
        int maxLength = cutRod(new int[]{3 ,5 ,6 ,7, 10, 12}, 6);
        System.out.println("maxLength = " + maxLength);
    }
}