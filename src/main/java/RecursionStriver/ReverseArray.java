package RecursionStriver;

public class ReverseArray {
    private  static  int[] a = {1,2,3,4,5};
    private static int n = a.length;
    public static void main(String[] args) {

        reverse(0, n-1);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    private static void reverse(int left, int n) {
        if(left>=a.length/2)
            return;

        int temp = a[left];
        a[left]= a[n];
        a[n]= temp;

        reverse(left+1, n-left-1);


    }
}
