package DPStriver;

class LongestPalindromeSubSequence {
    private static  int longestPalindromeSubseq(String s) {

        //reversal of the first string and do its lcs
        String s1= new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = s1.length();
        int dp[][] = new int[n+1][m+1];
        for(int i =0;i<=n;i++)
            dp[i][0]= 0;

        for(int j =0;j<=m;j++)
            dp[0][j]=0;

        int ans = 0;
        for(int i =1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(s.charAt(i-1)== s1.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int len  = longestPalindromeSubseq("bbbab");
        System.out.println("len = " + len);
    }
}