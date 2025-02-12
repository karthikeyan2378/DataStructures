package Recursion;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {4,1,3,6,5,7,3,9};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left<right)
        {
            int partitionIndex = findPart(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);

        }
    }

    private static int findPart(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i<j)
        {
            while(arr[i]<=pivot && i<=right-1)
            {
                i++;
            }
            while(arr[j]>pivot && j>=left+1)
            {
                j--;
            }

            if(i<j)
            {
                swap(arr, i, j);
            }

        }

        swap(arr, left, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]= temp;
    }
}
