package DPStriver;

public class MaxSubArray {
    private static  int maxProduct(int[] nums) {
        int res = nums[0];

        int min  = 1;
        int max = 1;

        for (int num : nums) {

            int t = num * max;

            max = Math.max(Math.max(t, min * num), num);
            min = Math.min(Math.min(t, num * min), num);

            res = Math.max(res, max);
        }


        return res;
    }

    public static void main(String[] args) {
        int max = maxProduct(new int[]{2,3,-1,4});
        System.out.println("max = " + max);
    }
}
