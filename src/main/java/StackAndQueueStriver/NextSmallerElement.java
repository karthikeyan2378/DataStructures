package StackAndQueueStriver;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] prever(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] small =  new int[n];
        Arrays.fill(small, -1);

        for(int i = 0;i<n;i++)
        {
            while(!s.isEmpty() && s.peek()>=nums[i])
            {
                s.pop();
            }

            if (!s.isEmpty()) {
                small[i] = s.peek();
            }
            s.push(nums[i]);

        }

        return small;
    }
    public static void main(String[] args) {

            int []small  = prever(new int[]{4 ,8 ,2, 1 ,6, 10 ,5});
            for (int a  : small)
                System.out.print(a + " ");
    }
}
