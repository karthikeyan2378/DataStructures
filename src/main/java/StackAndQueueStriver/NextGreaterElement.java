package StackAndQueueStriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        Stack<Integer> s = new Stack<>();
        for(int i =n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()<=nums2[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                map.put(nums2[i], -1);
                s.push(nums2[i]);
            }
            else
            {
                map.put(nums2[i], s.peek());
                s.push(nums2[i]);
            }
        }
        int[] nge = new int[nums1.length];
        for(int i =0;i<nums1.length;i++)
        {
            nge[i] =  map.get(nums1[i]);
        }

        return nge;
    }

    public static void main(String[] args) {
        int [] nge  = nextGreaterElement(new int[]{4,1,2}, new int[] {1,3,4,2});

        for (int a : nge)
        {
            System.out.print(a + " ");
        }

    }
}
