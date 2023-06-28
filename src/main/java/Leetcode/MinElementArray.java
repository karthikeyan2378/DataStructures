package Leetcode;

import java.util.Arrays;
import java.util.Map;

public class MinElementArray {
    private static int binarySearch(int[] a) {

        //baseCondition
        if(a.length == 1)
            return a[0];
        int left = 0;
        int right = a.length-1;
        while (left<right)
        {
            System.out.println("right = " + a[right]);
            System.out.println("left = " + a[left]);
            int m = left+(right-left)/2;
            System.out.println("m value = " + m);
            System.out.println("m = " + a[m]);
            //TODO always in sorted array left will be less then right element


            //TODO Core condition if middle element greater than or equal to left put left as m+1 or if failed put right = m
           if(a[left]<=a[m] && a[m]>a[right]) {
                left =m+1;
            }
            else
                right = m;
        }
       return a[left];
    }
    
    public static void main(String[] args) {
        int a[] = {3,1,2};

        System.out.println(binarySearch(a));
    }
}
