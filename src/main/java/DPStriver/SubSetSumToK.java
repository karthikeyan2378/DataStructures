package DPStriver;


public class SubSetSumToK {
    public static boolean solveMem(int n, int target, int[]arr, int[][]dp)
    {
        if(target == 0)
            return true;
        if(n == 0)
            return (arr[0]== target);

        if(dp[n][target] != -1)
            return dp[n][target] == 0 ?false:true;
        boolean notTake = solveMem(n-1, target, arr, dp);

        boolean take = false;

        if(arr[n]<=target)
            take = solveMem(n-1, target-arr[n], arr, dp);

        dp[n][target] = notTake || take ? 1 : 0;

        return  take|notTake;

    }

    public static boolean solveTab(int n, int target, int[] arr) {
        boolean dp[][] = new boolean[n][target + 1];

        // Base case: A subset sum of 0 is always possible (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize first row properly
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        // Build the DP table
        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= target; t++) {
                boolean notTaken = dp[ind - 1][t];
                boolean taken = false;
                if (arr[ind] <= t) {
                    taken = dp[ind - 1][t - arr[ind]];
                }
                dp[ind][t] = notTaken || taken;
            }
        }
        return dp[n - 1][target];
    }


    public static boolean solveSpace(int n, int k, int[] arr) {
        boolean prev[] = new boolean [k + 1];

        prev[0]= true;

        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean cur[] = new boolean[k + 1];
            cur[0]= true;
            for (int target = 1; target <= k; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                cur[target] = notTaken || taken;
            }
            prev= cur;
        }
        return prev[k];
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.

        //int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        //  for (int row[] : dp)
        //      Arrays.fill(row, -1);

        return solveTab(n, k, arr);
    }

    public static void main(String[] args) {
        boolean b = subsetSumToK(4,5, new int[]{4,3,2,1});
        System.out.println("ans = " + b);
    }
}
