package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {
    public static void wordBreak(String A, ArrayList<String> B )
    {
        //code here

    }
    public static void main(String[] args) {
        ArrayList<String>c = (ArrayList<String>) Arrays.asList( "i", "like", "sam",
                "sung", "samsung", "mobile",
                "ice","cream", "icecream",
                "man", "go", "mango" );
        String a = "ilike";
        wordBreak(a, c);
    }
}
