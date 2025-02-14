package DPStriver;

import java.util.Arrays;

public class Fibanocci {
    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int res  = f(n, dp);
        System.out.println("res = " + res);
    }

    private static int f(int n, int[] dp) {
        if(n<=1)
            return n;
        if(dp[n] != -1)
            return dp[n];

        return dp[n] = f(n-1, dp)+f(n-2, dp);
    }
}
