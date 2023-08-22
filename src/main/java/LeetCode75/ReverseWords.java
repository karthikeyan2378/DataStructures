package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";
        solution(s);
    }

    private static void solution(String s) {
         String[]r1 = s.trim().split(" +");
        Collections.reverse(Arrays.asList(r1));

        System.out.println("d = " + String.join(" ", r1));
    }
}
