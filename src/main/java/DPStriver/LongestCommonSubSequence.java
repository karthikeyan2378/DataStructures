package DPStriver;

class LongestCommonSubSequence {
    public static  int solve(int n, int m, String s1, String s2, int[][] dp)
    {
        if(n==0 || m==0)
            return 0;

        if(dp[n][m] !=-1)
            return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1))
            return 1 + solve(n-1, m-1, s1, s2, dp);

        return dp[n][m] = Math.max(solve(n-1, m, s1, s2, dp), solve(n, m-1, s1, s2, dp));
    }
    public static int longestCommonSubsequence(String text1, String text2) {

        int n =  text1.length();
        int m =  text2.length();
        //shifting of index done to solve tabulation
        int prev [] = new int[m+1];
        int curr [] = new int[m+1];


        //  for(int[] row :  dp)
        // Arrays.fill(row, 0);

        for(int i =0;i<=m;i++)
            prev[i] = 0;


        for(int i =1;i<=n;i++)
        {
            for(int j =1;j<=m;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];

                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }

        return prev[m];

        // return solve(n, m, text1,text2, dp);
    }

    public static void main(String[] args) {
        int min =longestCommonSubsequence("abcde", "ace");
        System.out.println("min = " + min);
    }
}