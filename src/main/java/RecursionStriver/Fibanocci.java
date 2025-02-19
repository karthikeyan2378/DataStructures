package RecursionStriver;

public class Fibanocci {
    //time complexity will be 2 to the power n times
    public static void main(String[] args) {
        System.out.println(fibbo(4));
    }

    private static int fibbo(int n) {
        if(n<=1)
            return n;
        return fibbo(n-1)+fibbo(n-2);
    }
}
