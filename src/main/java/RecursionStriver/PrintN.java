package RecursionStriver;

public class PrintN {
    private static int printN(int count, int n){
        if(count>n)
            return 0;
        System.out.println("Karthik"+count);
        count++;

        return printN(count, n);

    }
    public static void main(String[] args) {
        printN(1, 5);
    }
}
