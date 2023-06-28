package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ProductOfArrayExceptIt {
    public static void main(String[] args) {
        int a[] = {3,4,5,6,7};
        int res[] = new int[a.length];
        int prod = 1;
        for (int i = 0; i < a.length; i++) {
            System.out.println(prod);
            res[i]= prod;
            System.out.println("res[i] = " + res[i]);
            prod = prod*a[i];
            System.out.println("prii---{}"+ prod);

        }
        prod = 1;
        for (int i = a.length-1; i >=0; i--) {
            res[i]= prod;
            prod = prod*a[i];
        }



    }
}
