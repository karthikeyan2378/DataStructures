package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int a[] = {1, 3, 4, 5, 7, 10 , 11};
        sum(a, 9);
    }

    private static int[] sum(int[] a, int target) {

        Map<Integer, Integer>map = new HashMap<>();


        int l =0;
        int r = a.length-1;
        int curSum = 0;

        while (l<r)
        {
            curSum = a[l]+a[r];
            System.out.println("curSum = " + curSum);
            if(curSum>target) {
                r--;
            }
            else if(curSum<target)
            {
                l++;
            }
            else if(curSum == target)
            {

                System.out.println("l = " + l);
                System.out.println("r = " + r);
                return new int[]{l+1, r+1};
            }
            
        }
        System.out.println("map = " + map);

        return new int[]{};
    }
}
