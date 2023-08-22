package LeetCode75;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";

        solution(word1, word2);
    }

    private static void solution(String word1, String word2) {
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        char [] merge = new char[w1.length + w2.length];
        int i = 0;
        int j = 0;
        while (i < merge.length)
        {
            if(j<w1.length)
            {
                merge[i] = w1[j];
                i++;
            }
            if(j<w2.length)
            {
                merge[i] = w2[j];
                i++;
            }
            j++;
        }
        System.out.println("new String(merge) = " + new String(merge));
    }
}
