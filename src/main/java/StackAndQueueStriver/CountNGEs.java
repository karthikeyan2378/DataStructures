package StackAndQueueStriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class CountNGEs {
    public static int[] count_NGEs( int arr[], int queries, int indices[]) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Maintain a decreasing stack
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }

            // Store the count of greater elements
            countMap.put(i, stack.size());

            // Push current element into the stack
            stack.push(arr[i]);
        }

        // Process queries
        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            result[i] = countMap.getOrDefault(indices[i], 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] count_ngEs = count_NGEs(new int[]{3, 4, 2, 7, 5, 8, 10, 6}, 2, new int[]{0,5});

        for (int a  : count_ngEs)
            System.out.print(a + " ");
    }
}
