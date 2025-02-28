package DPStriver;

import java.util.Arrays;

public class DistinctSubSequence {
    public static int solve(int i , int j , String s, String t)
    {
        if(j<0)
            return 1;
        if(i<0)
            return 0;

        if(s.charAt(i)== t.charAt(j))
            return solve(i-1, j-1, s, t)+solve(i-1, j, s,t);
        else
            return solve(i-1, j, s, t);


    }

    //memoization

    public static int solve(int i , int j , String s, String t, int dp[][])
    {
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)== t.charAt(j))
            return dp[i][j]= solve(i-1, j-1, s, t, dp)+solve(i-1, j, s,t, dp);
        else
            return dp[i][j] = solve(i-1, j, s, t);


    }
    //tabulation use 1 based indexing


    public static int solveTab(int i , int j , String s, String t, int dp[][])
    {
        for(int n=0;n<=i;n++)
            dp[n][0] =1;


        for(int k =1;k<=i;k++)
        {
            for(int l=1;l<=j;l++)
            {
                if(s.charAt(k-1)== t.charAt(l-1))
                    dp[k][l]= dp[k-1][l-1] + dp[k-1][l];
                else
                    dp[k][l] = dp[k-1] [l];
            }
        }

        return dp[i][j];

    }

    //space optimization with 1Dp doubts pls check tuf
    public static int solveTabSpace(int i , int j , String s, String t)
    {
        int prev[] = new int[j+1];
        Arrays.fill(prev, 0);
        prev[0] = 1;


        for(int k =1;k<=i;k++)
        {
            for(int l=j;l>=1;l--)
            {
                if(s.charAt(k-1)== t.charAt(l-1))
                    prev[l]= prev[l-1] + prev[l];

            }
        }

        return prev[j];

    }
    public static  int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //  int[][] dp =  new int[n+1][m+1];
        // for(int[] row : dp)
        //   Arrays.fill(row, 0);
        //  Arrays.fill(row, -1);
        //  return solve(n-1, m-1, s, t, dp);

        // return solveTab(n,m,s,t,dp);
        return solveTabSpace(n,m,s,t);

    }

    public static void main(String[] args) {
        int minDistance = numDistinct("rabbbit", "rabbit");
        System.out.println("minDistance = " + minDistance);
    }
}
