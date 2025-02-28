package DPStriver;

class KnapSack {

    static int solve(int ind, int[] val, int[] wt, int weight)
    {
        if(ind == 0)
        {
            if(wt[ind]<=weight)
                return val[ind];
            else
                return 0;

        }


        int notTake =  0 +  solve(ind-1, val, wt, weight);
        int take = Integer.MIN_VALUE;

        if(wt[ind]<=weight)
        {
            take = val[ind]+solve(ind-1, val, wt, weight-wt[ind]);
        }
        return  Math.max(notTake, take);
    }

    static int solveMem(int ind, int[] val, int[] wt, int weight, int[][] dp)
    {
        if(ind == 0)
        {
            if(wt[ind]<=weight)
                return val[ind];
            else
                return 0;

        }
        if(dp[ind][weight] != -1 )
            return dp[ind][weight];
        int notTake =  0 +  solveMem(ind-1, val, wt, weight, dp);
        int take = Integer.MIN_VALUE;

        if(wt[ind]<=weight)
        {
            take = val[ind]+solveMem(ind-1, val, wt, weight-wt[ind], dp);
        }
        return dp[ind][weight] = Math.max(notTake, take);
    }
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];

        // Initialize base case
        for (int w = wt[0]; w <= capacity; w++) {
            dp[0][w] = val[0];  // If the first item can fit, assign its value
        }

        // Iterative DP approach
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= capacity; j++) {
                int notTake = dp[ind - 1][j];  // Value without taking current item
                int take = Integer.MIN_VALUE;

                if (wt[ind] <= j) {
                    take = val[ind] + dp[ind - 1][j - wt[ind]];  // Value if item is taken
                }

                dp[ind][j] = Math.max(notTake, take);  // Store max of taking/not taking
            }
        }

        return dp[n - 1][capacity];

    }

    public static void main(String[] args) {
        int theif = knapSack(4, new int[]{1,2,3}, new int[]{4,5,3});
        System.out.println("theif = " + theif);
    }
}
