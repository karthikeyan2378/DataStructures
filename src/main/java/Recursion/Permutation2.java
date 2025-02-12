package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>>result = new ArrayList<>();

        permute( 0, arr, result);
        System.out.println(result);
    }

    private static void permute( int index, int[] arr, List<List<Integer>> result) {

        if(index== arr.length)
        {
            List<Integer>ds = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                ds.add(arr[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
                swap(i, index, arr);
                permute(index+1, arr, result);
                swap(i, index, arr);

        }

        }

        private static void swap(int l, int r, int[] nums) {
            int temp  =nums[l];
            nums[l]=nums[r];
            nums[r]= temp;
        }
    }

