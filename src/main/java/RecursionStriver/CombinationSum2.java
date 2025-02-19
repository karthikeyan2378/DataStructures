package RecursionStriver;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    private static void findCombinationSumRecursive(int index, int[] arr, int target, List<List<Integer>> resultSum, ArrayList<Integer> ds) {

            if(target == 0) {
                resultSum.add(new ArrayList<>(ds));
                return;
            }


        for (int i = index;i<arr.length;i++)
        {
            if(i>index && arr[i] == arr[i-1] )
                continue;
            if(arr[i]>target)
                break;
            ds.add(arr[index]);
            findCombinationSumRecursive(i+1, arr, target-arr[i], resultSum, ds);
            ds.remove(ds.size()-1);
        }


    }
    public static void main(String[] args) {
        int arr[] = {1,1,1, 2,2};
        int target = 4;
        List<List<Integer>> resultSum = new ArrayList<>();
        List<Integer>ds = new ArrayList<>();
        findCombinationSumRecursive(0, arr, target,resultSum, (ArrayList<Integer>) ds);
        System.out.println(resultSum);

    }
}
