package DPStriver;

class MinimumDeletionOrInsertion {
    private static  int minDistance(String s, String s1) {
        int n = s.length();
        int m = s1.length();
        int dp[][] = new int[n+1][m+1];
        for(int i =0;i<=n;i++)
            dp[i][0]= 0;

        for(int j =0;j<=m;j++)
            dp[0][j]=0;

        
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


        // formula  - > n-k + m-k where k is lcs
        return (n - dp[n][m]) + (m-dp[n][m]);
    }

    public static void main(String[] args) {
        int minDistance =  minDistance("eat", "sea");
        System.out.println("minDistance = " + minDistance);
    }
}