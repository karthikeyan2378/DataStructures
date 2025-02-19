package RecursionStriver;

public class Palindrome {
    public static void main(String[] args) {
        String s = "MADAM";
        System.out.println(reverse(s, 0, s.length()));
    }

    private static boolean reverse(String s, int left, int n) {
        if(left>=n/2)
            return true;
        if(s.charAt(left)!= s.charAt(n-left-1))
            return false;

        return  reverse(s, left+1, n);

    }
}
