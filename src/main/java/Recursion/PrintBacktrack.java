package Recursion;

public class PrintBacktrack {
    public static void main(String[] args) {
        printN(1,3);
    }

    private static void printN(int count, int n) {
        if(count>n)
            return;
        //Backtracking
        printN(count+1,n);
        //Backtrack concept is here
        System.out.println(count);
    }
}
