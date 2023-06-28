package Leetcode;

public class RotateString {
    public static boolean rotate(String s, String goal)
    {
        return (s.length()==goal.length() && (s+s).contains(goal));
    }
    public static void main(String[] args) {
        System.out.println("rotate(\"abcde\",\"bcdea\") = " + rotate("abcde","bcdea"));
    }
}
