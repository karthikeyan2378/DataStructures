package StackAndQueueStriver;

import java.util.Stack;

public class NextGreaterElement2 {
    public static  int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] nge =  new int[n];

        for(int i = 2*n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=nums[i%n])
            {
                s.pop();
            }

            if(i<n)
            {
                nge[i] = (s.isEmpty())?-1:s.peek();
            }

            s.push(nums[i%n]);
        }

        return nge;

    }

    public static void main(String[] args) {
        int [] nge  = nextGreaterElements(new int[]{1,2,1});

        for (int a : nge)
            System.out.print(a + " ");
    }

}
