package DPStriver;

class UniquePathsWithObstacle {
    public static int solveSpace(int m, int n, int[][]grid)
    {
        int prev[]=new int[n];

        for(int i=0;i<m;i++)
        {
            int temp[] =  new int[n];
            for(int j =0;j<n;j++)
            {
                if(grid[i][j] != 1)
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
            }

            prev = temp;
        }

        return prev[n-1];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;
        return solveSpace(m,n, obstacleGrid);
    }

    public static void main(String[] args) {

    }
}