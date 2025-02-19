package DPStriver;

class HouseRobber1 {
    //tabulation
    public static int solve(int n, int[] nums, int[] dp)
    {
        if(n==0)
            return nums[0];
        if(n<0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int pick = nums[n] + solve(n-2, nums, dp);
        int notPick =  0+solve(n-1, nums, dp);
        return dp[n] = Math.max(pick, notPick);
    }

    // tabulation with space optimization
    public static int solve2(int[] nums)
    {
        int n =  nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i =1;i<n;i++)
        {
            int take =  nums[i];
            if(i>1)
                take += prev2;
            int notTake =  0 + prev;
            int curr = Math.max(take, notTake);
            prev2= prev;
            prev = curr;
        }
        return prev;

    }

    public static int rob(int[] nums) {
        int n = nums.length;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // return solve(n-1, nums, dp);
        return solve2(nums);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        int min= rob(arr);
        System.out.println("min = " + min);
    }
}