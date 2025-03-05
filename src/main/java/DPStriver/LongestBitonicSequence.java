package DPStriver;

import java.util.Arrays;

public class LongestBitonicSequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);


        for(int i=0; i<=n-1; i++){

            for(int prev_index = 0; prev_index <=i-1; prev_index ++){

                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                }
            }
        }



        for(int i=n-1; i>=0; i--){

            for(int prev_index = n-1; prev_index >i; prev_index --){

                if(arr[prev_index]<arr[i] && 1 + dp1[prev_index] > dp1[i]){
                    dp1[i] = 1 + dp1[prev_index];
                }
            }
        }

        int max =1;
        for(int i =0;i<n;i++)
        {
            max = Math.max(max, dp[i]+dp1[i]-1);
        }

        return max;

    }

    public static void main(String[] args) {
        int max = longestBitonicSequence(new int[]{1, 2, 1, 2, 1}, 5);
        System.out.println("max = " + max);
    }
}
