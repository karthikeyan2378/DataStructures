package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        boolean freq[] = new boolean[arr.length];
        List<List<Integer>>result = new ArrayList<>();

        permute( arr, freq,  result, new ArrayList<>());
        System.out.println(result);
    }

    private static void permute( int[] arr, boolean[] freq, List<List<Integer>> result, List<Integer>ds) {
        if(ds.size() == arr.length)
        {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!freq[i])
            {
                freq[i] = true;
                ds.add(arr[i]);
                permute(arr, freq, result, ds);
                ds.remove(ds.size()-1);
                freq[i]= false;
            }

        }
    }
}
