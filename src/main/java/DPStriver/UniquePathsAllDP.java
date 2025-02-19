package DPStriver;

class UniquePathsAllDP {
    //recursive approach
    public static int solverecursive(int i, int j)
    {
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        int up = solverecursive(i-1, j);
        int left = solverecursive(i,j-1);
        return up+left;
    }
    //memoizationApproach
    public static int solvememo(int i, int j , int dp[][])
    {
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int up = solvememo(i-1, j, dp);
        int left = solvememo(i,j-1, dp);

        return dp[i][j] = up+left;
    }

    // tabulation technique
    public static int solveTabulation(int m, int n)
    {
        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(i==0 && j == 0)
                    dp[i][j]=1;
                else
                {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;  // Sum of ways from top and left
                }
            }
        }

        return dp[m-1][n-1];

    }

    // space optimization technique from tabulation
    public static int solveSpace(int m, int n)
    {
        int prev[]=new int[n];

        for(int i=0;i<m;i++)
        {
            int temp[] =  new int[n];
            for(int j =0;j<n;j++)
            {
                if(i==0 && j == 0)
                    temp[j]=1;
                else
                {
                    int up = (i > 0) ? prev[j] : 0;
                    int left = (j > 0) ? temp[j - 1] : 0;
                    temp[j] = up + left;  // Sum of ways from top and left
                }
            }

            prev = temp;
        }

        return prev[n-1];

    }
    private static int uniquePaths(int m, int n) {
        // return solverecursive(m-1,n-1);

        // int dp[][]=new int[m][n];
        // for(int i =0;i<m;i++)
        //  for(int j =0;j<n;j++)
        // dp[i][j]= -1;
        //   return solvememo(m-1,n-1,dp);

        //  return solveTabulation(m,n);
        return solveSpace(m,n);

    }

    public static void main(String[] args) {
        int uni = uniquePaths(3,2);
        System.out.println("uni = " + uni);
    }
}