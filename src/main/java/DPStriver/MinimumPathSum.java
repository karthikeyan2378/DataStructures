package DPStriver;

class MinimumPathSum {
    //direct space optimization
    public static int solveSpace(int m, int n, int[][]grid)
    {
        int prev[]=new int[n];

        for(int i=0;i<m;i++)
        {
            int temp[] =  new int[n];
            for(int j =0;j<n;j++)
            {
                if(i==0 && j == 0)
                    temp[j]=grid[i][j];
                else
                {
                    int up = (i > 0) ? prev[j]: Integer.MAX_VALUE;
                    int left = (j > 0) ? temp[j - 1]: Integer.MAX_VALUE;
                    temp[j] = grid[i][j]+Math.min(up, left);  // Sum of ways from top and left
                }
            }

            prev = temp;
        }

        return prev[n-1];

    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        return solveSpace(m,n, grid);
    }

    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        int min = minPathSum(points);
        System.out.println("min = " + min);
    }
}