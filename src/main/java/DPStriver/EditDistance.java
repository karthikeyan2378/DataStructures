package DPStriver;

import java.util.Arrays;

public class EditDistance {
    public static int solve(int n, int m, String s1, String s2)
    {
        if(n<0)
            return m+1;
        if(m<0)
            return n+1;

        if(s1.charAt(n)== s2.charAt(m))
            return 0 + solve(n-1, m-1, s1, s2);
        int insert = 1+ solve(n, m-1, s1, s2);
        int delete = 1+ solve(n-1, m, s1, s2);
        int replace = 1+ solve(n-1, m-1, s1, s2);
        return Math.min(insert, Math.min(delete, replace));
    }

    // memoization
    public static int solve(int n, int m, String s1, String s2, int[][] dp)
    {
        if(n<0)
            return m+1;
        if(m<0)
            return n+1;
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(s1.charAt(n)== s2.charAt(m))
            return 0 + solve(n-1, m-1, s1, s2, dp);
        int insert = 1+ solve(n, m-1, s1, s2, dp);
        int delete = 1+ solve(n-1, m, s1, s2, dp);
        int replace = 1+ solve(n-1, m-1, s1, s2, dp);
        return dp[n][m] = Math.min(insert, Math.min(delete, replace));
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][]= new int[n][m];
        for(int[] row :  dp)
            Arrays.fill(row, -1);
        return solve(n-1, m-1, word1, word2, dp);
    }

    public static void main(String[] args) {
        int minDistance =  minDistance("horse", "ros");
        System.out.println("minDistance = " + minDistance);
    }
}
