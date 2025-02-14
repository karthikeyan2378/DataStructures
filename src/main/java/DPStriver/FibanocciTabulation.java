package DPStriver;

public class FibanocciTabulation {
    public static void main(String[] args) {
        int n =10;
        int res  = f(n);
        System.out.println("res = " + res);
    }

    private static int f(int n) {
        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <=n ; i++) {
            int curri = prev2+prev1;
            prev2 =  prev1;
            prev1 = curri;
        }

        return prev1;
    }
}
