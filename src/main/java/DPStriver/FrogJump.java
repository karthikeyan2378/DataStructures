package DPStriver;

import java.util.*;
import java.lang.Math;

public class FrogJump {
    //top to down approach
    public static int solve(int n, int heights[], int dp[]) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int left = solve(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE; // Use Integer.MAX_VALUE instead of 1000

        if (n > 1)
            right = solve(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);

        return dp[n] = Math.min(left, right);
    }

    public static int solve2(int n, int heights[]) {

        int prev =0;
        int prev2 = 0;
        if (n == 0)
            return 0;

        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE; // Use Integer.MAX_VALUE instead of 1000

            if (i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curri =  Math.min(left, right);
            prev2 = prev;
            prev = curri;
        }


       return prev;
    }


    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,10};
       // int min = frogJump(4, arr);
        int min = solve2(4, arr);
        System.out.println("min = " + min);
    }
}
