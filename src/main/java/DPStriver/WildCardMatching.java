package DPStriver;

import java.util.Arrays;

public class WildCardMatching {
    public static boolean solve(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = solve(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }

        if (p.charAt(j) == '*') {
            dp[i][j] = (solve(i - 1, j, s, p, dp) || solve(i, j - 1, s, p, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }

        return dp[i][j] == 0;
    }

    public static  boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, m - 1, s, p, dp);
    }

    public static void main(String[] args) {
        boolean matched =  isMatch("aaa", "a*a");
        System.out.println("matched = " + matched);
    }
}
