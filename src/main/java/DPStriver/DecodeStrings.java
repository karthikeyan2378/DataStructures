package DPStriver;

import java.util.Arrays;

public class DecodeStrings {
    public static int solve(int ind, String s, int[] dp)
    {
        if(ind == s.length())
            return 1;

        if(s.charAt(ind)== '0')
            return 0;

        if(dp[ind]!=-1)
            return dp[ind];
        int ways = solve(ind+1, s, dp);

        if(ind+1<s.length() && Integer.parseInt(s.substring(ind, ind+2))<=26)
        {
            ways += solve(ind+2, s, dp);
        }
        return dp[ind] = ways;
    }
    public static int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }

    public static void main(String[] args) {
        int ways = numDecodings("226");
        System.out.println("ways = " + ways);
    }
}
