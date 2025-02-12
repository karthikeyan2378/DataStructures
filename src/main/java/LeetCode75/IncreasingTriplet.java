package LeetCode75;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        System.out.println("a = " + solution(a));
    }

    private static boolean solution(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= a){
                System.out.println("a = " + a);
                a= nums[i];
            }
            else if(nums[i] < b){
                System.out.println("b = " + b);
                b=nums[i];
            }
            else if(nums[i] > b){
                System.out.println("b1 = " + b);
                return true;
            }
        }
        return false;
    }
}
