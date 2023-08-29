package LeetCode75;

import java.util.Arrays;

public class ProductOfArrayItself {
    public static void main(String[] args) {
        int[] a =  {1,2,3,4};
        solution(a);
    }

    private static void solution(int[] a) {
        int[] res = new int[a.length];
        int prod =1;
        for (int i = 0; i < a.length; i++) {
            res[i] = prod;
            prod = prod *a[i];
        }
        prod = 1;
        for (int i = a.length-1; i >=0 ; i--) {
            res[i] = prod;
            prod = prod * a[i];
        }
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
    }

}
