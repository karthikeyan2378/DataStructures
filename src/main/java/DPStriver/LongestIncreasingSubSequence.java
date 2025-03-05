package DPStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequence {
    //recursion
    public int solve(int ind, int prevIndex, int[] nums)
    {
        if(ind == nums.length)
            return 0;

        int len =  0 +  solve(ind+1, prevIndex, nums);
        if(prevIndex == -1 || nums[ind]>nums[prevIndex])
        {
            len =Math.max(1+ solve(ind+1, ind, nums), len);
        }
        return len;
    }

    //memoization
    public static int solve(int ind, int prevIndex, int[] nums, int[][] dp)
    {
        if(ind == nums.length)
            return 0;

        if(dp[ind][prevIndex+1]!=-1)
            return dp[ind][prevIndex+1];
        int len =  0 +  solve(ind+1, prevIndex, nums, dp);
        if(prevIndex == -1 || nums[ind]>nums[prevIndex])
        {
            len =Math.max(1+ solve(ind+1, ind, nums, dp), len);
        }
        return dp[ind][prevIndex+1] = len;
    }

    public static  int solveTabulation(int[] nums)
    {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int[] row : dp)
            Arrays.fill(row, 0);
        for(int ind = nums.length-1;ind>=0;ind--)
        {
            for(int prevIndex = ind-1;prevIndex>=-1;prevIndex--)
            {
                int len =  0 +  dp[ind+1][prevIndex+1];
                if(prevIndex == -1 || nums[ind]>nums[prevIndex])
                {
                    len =Math.max(1+ dp[ind+1][ind+1], len);
                }
                dp[ind][prevIndex+1] = len;
            }
        }


        return dp[0][-1+1];
    }
    public static int solveTabulation2(int[] arr)
    {
        int n = arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);

        for(int i=0; i<=n-1; i++){

            hash[i] = i; // initializing with current index
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){

                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex =-1;

        for(int i=0; i<=n-1; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);

        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();

        return ans;
    }

    public static int usingBinarySearch(int[] arr)
    {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                // arr[i] > the last element of temp array

                temp.add(arr[i]);
                len++;
            } else {
                // Replacement step
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                temp.set(ind, arr[i]);
            }
        }

        return len;
    }
    public static int lengthOfLIS(int[] nums) {

        int dp[][] = new int[nums.length][nums.length+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
       // return solve(0, -1, nums, dp);
       // return solveTabulation(nums);
        return usingBinarySearch(nums);
    }

    public static void main(String[] args) {
        int longestIncreasingSubSequence = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println("longestIncreasingSubSequence = " + longestIncreasingSubSequence);
    }
}
