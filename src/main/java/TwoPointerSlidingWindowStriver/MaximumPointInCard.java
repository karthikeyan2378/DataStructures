package TwoPointerSlidingWindowStriver;

class MaximumPointInCard {
    public static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        int n = cardPoints.length;

        // Compute initial left sum (taking first k elements)
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum; // Initialize maxSum with leftSum

        int rightIndex = n - 1;
        for (int j = k - 1; j >= 0; j--) {
            leftSum -= cardPoints[j]; // Remove from left
            rightSum += cardPoints[rightIndex]; // Add from right
            rightIndex--; // Move right pointer
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int max = maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println("maxPoint = " + max);
    }
}
