package Test;

import java.util.HashSet;
import java.util.Set;

public class NielsenQuestion1 {
    public static void main(String[] args) {
        String arr[] = {"co", "dil" ,"ity"};
        Set<String> res = new HashSet<>();

        StringBuffer sb = new StringBuffer();

        for (String item : arr) {
            sb.append(item);
        }
        res.add(sb.toString());
        for (String s : arr) {
            for (String value : arr) {
                res.add(s + value);
            }
        }

        for (int i = arr.length-1; i >0;i--) {
            for (int j = arr.length-1; j >0; j--) {
                res.add(arr[i]+arr[j]);
            }
        }

        int maxLength = 0;
        for (String a : res)
        {
            char[] f = a.toCharArray();
            int length =  f.length;
            Set<Character>f1 = new HashSet<>();
            for (char c : f) {
                f1.add(c);
            }
            int length2 = f1.size();

            System.out.println("length2 = " + length2);
            System.out.println("length = " + length);
            if(length == length2) {
                maxLength = Math.max(maxLength, length);
            }

        }

        System.out.println("ans = " + res);
        System.out.println("maxLength = " + maxLength);
    }
}
