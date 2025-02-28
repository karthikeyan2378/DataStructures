package DPStriver;

import java.util.Arrays;

public class LongestCommonSubString {

    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        int ans = 0;

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2

                    ans = Math.max(dp[ind1][ind2], ans);
                }
                else
                    dp[ind1][ind2] = 0;
            }
        }

        System.out.println("ans = " + ans);
       return ans; // Return the length of the Longest Common substring (LCS)


    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abe";
        lcs(s1, s2);
    }
}
