package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        /* Your class should be named Main.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        String a[]  = new String[n];
        for (int i = 0; i < a.length; i++) {
            System.out.println("i = " + i);
            a[i] = myObj.next();
        }
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            Map<Character, Integer>aq = new HashMap<>();
            String s = a[i];
            for (int index = 0; index < s.length(); index++) {
                if(aq.containsKey(s.charAt(index)))
                {
                    int currentCount = index - aq.get(s.charAt(index))-1;
                    count = Math.max(currentCount, count);
                    aq.put(s.charAt(index), index);
                }
                else{
                    aq.put(s.charAt(index), index);
                }
            }
            System.out.println(count);
        }


    }
}
