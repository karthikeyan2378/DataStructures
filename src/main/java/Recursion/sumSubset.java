package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sumSubset {
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        int n = 3;
        List<Integer> subSetSum =  new ArrayList<>();
        subSetSumCalc(0,0, arr,n, subSetSum);
        Collections.sort(subSetSum);
        System.out.println(subSetSum);
    }

    private static void subSetSumCalc(int index, int sum, int[] arr, int n,  List<Integer> subSetSum) {
        if(index == n)
        {
            subSetSum.add(sum);
            return;
        }

        subSetSumCalc(index+1, sum+arr[index], arr, n, subSetSum);//Take the element
        subSetSumCalc(index+1, sum, arr, n, subSetSum);// Not Take the element
    }
}
