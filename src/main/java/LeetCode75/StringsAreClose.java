package LeetCode75;

import java.util.*;

public class StringsAreClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        solution(word1, word2);
    }


    private static boolean solution(String word1, String word2) {

        if(word1.length() != word2.length())
            return false;

        Map<Character, Integer> word1Count =  new HashMap<>();
        Map<Character, Integer> word2Count =  new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            word1Count.merge(word1.charAt(i), 1, Integer::sum);
            word2Count.merge(word2.charAt(i), 1, Integer::sum);
        }


        List<Integer> w1Count = new ArrayList<>();
        List<Integer>w2Count = new ArrayList<>();

        word1Count.forEach((key, value)->w1Count.add(value));
        word2Count.forEach((key, value)->w2Count.add(value));


        Collections.sort(w1Count);
        Collections.sort(w2Count);

        return w1Count.equals(w2Count) && word1Count.keySet().containsAll(word2Count.keySet()) && word2Count.keySet().containsAll(word1Count.keySet());
    }
}
