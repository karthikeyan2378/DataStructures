package LeetCode75;

public class AverageSubArray {
    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;
        solution(nums, k);
    }

    private static void solution(int[] nums, int k) {

        int maxSum = 0;
        for (int i = 0; i <k ; i++) {
            maxSum = maxSum + nums[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }
        System.out.println("maxSum = " + maxSum);
        System.out.println("maxAverage = " + (double) maxSum/k);
    }
}
