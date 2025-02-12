package Test;

public class ReverseArray {
    public static void main(String[] args) {
        int a[] ={1,2,3,4,5};
        reverse(a, 0, a.length-1);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void reverse(int[] a, int start, int end) {
        int temp;
        while(start<end)
        {
            temp =  a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;

        }
    }
}
