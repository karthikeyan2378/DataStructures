package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int f = factorial(4);
        System.out.println(f);
    }

    private static int factorial(int i) {
        if(i < 1)
            return 1;

        return  i * factorial(i-1);
    }
}
