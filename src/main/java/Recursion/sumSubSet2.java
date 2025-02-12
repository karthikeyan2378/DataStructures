package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumSubSet2 {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        Arrays.sort(arr);
        List<List<Integer>> resultSets = new ArrayList<>();
        getSubSet(0,arr, resultSets, new ArrayList<>());
        System.out.println(resultSets);

    }

    private static void getSubSet(int index, int[] arr, List<List<Integer>> resultSets, ArrayList<Integer> currentList) {
        resultSets.add(new ArrayList<>(currentList));
        for (int i = index; i < arr.length; i++) {
            if(i!=index && arr[i] == arr[i-1] )
                continue;
            currentList.add(arr[i]);
            getSubSet(i+1, arr, resultSets, currentList);
            currentList.remove(currentList.size()-1);
        }

    }
}
