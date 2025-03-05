package DPStriver;

import java.util.Arrays;

public class NumberOfLIS {
    public static int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] count=new int[n];
        Arrays.fill(count,1);
        int max = 1;

        for(int i=0; i<n; i++){

            for(int prev_index = 0; prev_index <i; prev_index ++){

                if(arr[i] > arr[prev_index] && 1+ dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    //inherit
                    count[i] = count[prev_index];
                }
                else if(arr[i] > arr[prev_index] && (1+ dp[prev_index] == dp[i]))
                {
                    //increase count
                    count[i] += count[prev_index];
                }

            }

            max = Math.max(max, dp[i]);

        }

        int nos = 0;
        for(int i =0;i<n;i++)
        {
            if(dp[i]== max)
                nos += count[i];
        }

        return nos;

    }

    public static void main(String[] args) {
        int nos = findNumberOfLIS(new int[]{1,3,5,4,7});
        System.out.println("nos = " + nos);
    }
}
