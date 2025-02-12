package Recursion;

public class FunctionalWaySum {
    public static void main(String[] args) {
        int sum = sum(5);
        System.out.println(sum);
    }

    private static int sum(int i) {
        if(i == 0)
            return 0;
        return i + sum(i-1);

    }
}
