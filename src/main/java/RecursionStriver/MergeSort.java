package RecursionStriver;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right)
    {
        if(left>=right)
            return;
        System.out.println("ll"+arr.length);
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        List<Integer> list = new ArrayList<>();
        int l = left;
        int r = mid+1;
        while(l<=mid && r<=right)
        {
            if(arr[l]<=arr[r])
            {
                list.add(arr[l]);
                l++;
            }
            else
            {
                list.add(arr[r]);
                r++;
            }

        }

        while(l<=mid)
        {
            list.add(arr[l]);
                    l++;
        }
        while(r<=right)
        {
            list.add(arr[r]);
                    r++;
        }

        System.out.println(list);
        int i =0;
        for (int n : list)
        {
            arr[left+i]= n;
            i++;
        }


    }

    public static void main(String[] args) {
        int arr[] = {3,1,2,1,4,5};
        mergeSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
