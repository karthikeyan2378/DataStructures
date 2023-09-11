package LeetCode75;

import java.util.*;

public class MaxVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        solution(s, k);
    }

    private static int solution(String s, int k) {
        int length = s.length();
        if(length<k) return 0;
        int count = 0;

        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))) count++;
        }

        System.out.println("count = " + count);

        int max = count;

        int end = k-1;
        int start = 0;

        while(end<length-1){
            System.out.println("end = " + end);
            System.out.println("start = " + start);
            System.out.println("count = " + count);
            if(isVowel(s.charAt(start)) && count>0) count--;
            if(isVowel(s.charAt(end+1))) count++;
            start++;
            end++;
            max = Math.max(count,max);
        }

        return max;

    }
    private static boolean isVowel(Character c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}
