package DPStriver;

class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Iterate from the second last row up to the first row
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int straight = matrix[i - 1][j];  // From directly above
                int leftDiagonal = (j > 0) ? matrix[i - 1][j - 1] : Integer.MAX_VALUE; // Left diagonal
                int rightDiagonal = (j < n - 1) ? matrix[i - 1][j + 1] : Integer.MAX_VALUE; // Right diagonal

                // Update current cell with the minimum falling sum
                matrix[i][j] += Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum value in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[m - 1][j]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        int min = minFallingPathSum(points);
        System.out.println("min = " + min);
    }
}
