package INterview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Interview1 {
    public static void main(String[] args) {
        String a = "abdgggda";
        String b = "abdggda";
        int n = a.length();
        int m = b.length();
        System.out.println("m = " + m);
        List<Integer> index = new ArrayList<>();
          solve(0, 0, a, b, index);
          if(index.isEmpty())
              index.add(-1);
        Collections.reverse(index);
        System.out.println(index);

    }

    private static boolean solve(int n, int m, String a, String b, List<Integer> index) {
        if(m==b.length())
        {
            return true;
        }

        if(n==a.length())
            return false;

        boolean found = false;

        if(a.charAt(n)==b.charAt(m))
        {
            found = solve(n+1,m+1, a, b, index);
        }

        if(solve(n+1, m,a,b, index))
        {
            index.add(n);
            found = true;
        }
        return found;
    }
}
