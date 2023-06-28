package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LcsWithoutDuplicates {
    public static void main(String[] args) {
        String a = "pwwkew";
        lengthOfString(a);
    }

    private static void lengthOfString(String a) {
        char[]sub = new char[256];
        sub[0] = a.charAt(0);
        int seq_start =0; // store sequence start position
        int seq_end = 1; // store the length of subarray
        int max_count = 1;
        // Iterate over each character
        for (int i = 1; i < a.length()-1; i++) {
            // Iterate over each element in subsequence
            for (int j=seq_start; j<seq_end; j++)
            {
                // if current character is in sequence, update the sequence_start to the next index of first repitition
                if (sub[j] == a.charAt(i)){
                    seq_start = j+1;
                }
            }
                sub[seq_end++] = a.charAt(i); // adds element to sequence by default
            int current_count = seq_end-seq_start + 1; // get the current count (r-l+1)
            max_count = Math.max(max_count, current_count); // update maximum count
        }
        System.out.println("max_count = " + max_count);
    }
}


/*
subseq = []
for char in str:
    for val in len(subseq):
        if val in subseq:
            h
    subseq.append(char)
    count(subseq)
 */