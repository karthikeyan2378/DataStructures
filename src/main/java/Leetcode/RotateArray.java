package Leetcode;

public class RotateArray {
    public static void main(String[] args) {
        int a[] ={-1,-100,3,99};
        int d = 2;
        rotate(a, d);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        System.out.println("k = " + k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
