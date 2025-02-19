package RecursionStriver;

public class ParameterWaySum {

    public static void main(String[] args) {
        int sum = printSum(5, 0);
        System.out.println(sum);
    }

    private static int printSum(int num, int sum) {
        if(num<1) {
            return sum;
        }
        return  printSum(num-1, num+sum);

    }
}
