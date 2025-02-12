package Recursion;

public class PrintLinear {
    private static int printN(int count, int n){
        if(count == 0)
            return 0;
        System.out.println(count);
        count--;

        return printN(count, n);

    }
    public static void main(String[] args) {
        printN(5, 5);
    }
}

