package StringQuestion;

import java.math.BigInteger;

public class MultiplyStrings {
    public static void main(String[] args) {
        String s1 ="88888888888888888";
        String s2 = "6666666666666666";
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);
        BigInteger ans = a.multiply(b);
        System.out.println("ans = " +  ans.toString());
    }
}
