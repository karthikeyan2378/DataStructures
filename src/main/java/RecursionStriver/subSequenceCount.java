package RecursionStriver;

import java.util.ArrayList;
import java.util.List;

public class subSequenceCount {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int k = 3;
        List<Integer> integerList = new ArrayList<>();
        int count = sequence(0, arr, integerList, k, 0);
        System.out.println("Count = " + count);
    }

    private static int sequence(int n, int[] list, List<Integer> integerList, int k, int sum) {
        if (n == list.length) {  // Base case: when n reaches the end of the array
            if(k==sum) {
                System.out.println(integerList);
                return 1;
            }

            return 0;
        }

        // Include the current element
        integerList.add(list[n]);
        sum+= list[n];
        int left = sequence(n + 1, list, integerList, k, sum);

        // Exclude the current element
        integerList.remove(integerList.size()-1);
        sum-=list[n];
        int right =  sequence(n + 1, list, integerList, k, sum);

        return left+right;

    }
}
