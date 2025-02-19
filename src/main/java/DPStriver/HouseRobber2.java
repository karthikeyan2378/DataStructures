package DPStriver;

//circular format
class HouseRobber2 {

    public static int solve(int[] nums)
    {
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1;i<nums.length;i++)
        {
            int take = nums[i];
            if(i>1)
                take += prev2;

            int notTake =  0 + prev;
            int curr = Math.max(take, notTake);
            prev2=prev;
            prev =  curr;
        }

        return prev;
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        if(n==1)
            return nums[0];
        for(int i =0;i<n;i++)
        {
            if(i!=0)
                temp1[i]= nums[i];
            if(i!=n-1)
                temp2[i]= nums[i];
        }

        return Math.max(solve(temp1), solve(temp2));
    }

    public static void main(String[] args) {
        int arr[] = {2,3,2};
        int min = rob(arr);
        System.out.println("min = " + min);
    }
}