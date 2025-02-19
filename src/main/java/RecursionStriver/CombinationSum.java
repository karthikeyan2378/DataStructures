package RecursionStriver;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {2,3,6,7};
        int target = 7;
        findCombinationSum(arr, target);
    }

    private static void findCombinationSum(int[] arr, int target) {
        List<List<Integer>>resultSum = new ArrayList<>();
         findCombinationSumRecursive(0, arr, target, resultSum, new ArrayList<>());
        System.out.println(resultSum);
    }

    private static void findCombinationSumRecursive(int index, int[] arr, int target, List<List<Integer>> resultSum, ArrayList<Integer> ds) {
        if(index == arr.length)
        {
            if(target == 0) {
                resultSum.add(new ArrayList<>(ds));
            }
                return ;

        }

        if(arr[index]<=target)
        {
            ds.add(arr[index]);
            findCombinationSumRecursive(index, arr, target-arr[index], resultSum, ds);
            ds.remove(ds.size()-1);
        }

        findCombinationSumRecursive(index+1, arr, target,resultSum, ds);

    }
}
