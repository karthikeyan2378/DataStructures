package LeetCode75;

public class GcdOfString {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String solution = solution(str1, str2);
        System.out.println("solution = " + solution);
    }

    private static String solution(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int length, int length1) {
        if(length1 !=  0)
            return gcd(length1, length%length1);
        return length;
    }
}
