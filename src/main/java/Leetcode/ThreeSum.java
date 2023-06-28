package Leetcode;

import java.util.*;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] a) {

        Arrays.sort(a);

        Set<List<Integer>> res=new HashSet<>();

        for (int i = 0; i < a.length-2; i++) {


            int left = i+1;
            int right = a.length - 1;

            int curSum;
            while (left < right) {
                curSum = a[i] + a[left] + a[right];
                if (curSum == 0) {
                    res.add(Arrays.asList(a[i], a[left], a[right]));
                    right--;
                }

                else if (curSum > 0)
                    right--;
                else left++;

            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int a[] = {-1,0,1,2,-1,-4};
        System.out.println("a = " + threeSum(a));
    }
}