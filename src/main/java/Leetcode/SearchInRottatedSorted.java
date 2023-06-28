package Leetcode;

public class SearchInRottatedSorted {
    private static int searchInRotated(int[] a, int target, int left, int right) {

        while (left<right)
        {

            int middle = left+(right-left)/2;
            System.out.println("middle = " + a[middle]);
            System.out.println("left = " + a[left]);

            if(a[middle] == target)
                return middle;
            if(a[middle] > target && target<a[left])
                return searchInRotated(a, target, middle+1, a.length-1);
            //TODO Core condition if middle element greater than or equal to left put left as m+1 or if failed put right = m
            else
                return searchInRotated(a, target, 0, middle);
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[] = {4,5,6,7,0,1,2};
        int target = 8;
        System.out.println("result = " + searchInRotated(a, target, 0, a.length-1));
    }
}
