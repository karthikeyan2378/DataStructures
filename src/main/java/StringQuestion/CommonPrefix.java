package StringQuestion;

public class CommonPrefix {
    public static String commonPrefixUtil(String s1, String s2)
    {
        String res = "";
        for(int i =0, j =0;i<s1.length()&&j<s2.length();i++,j++)
        {
            if(s1.charAt(i) != s2.charAt(j))
            {
                break;
            }
            res = res+s1.charAt(i);
        }
        return res;
    }
    public static String commonPrefix(String []arr, int n)
    {
        String prefix = arr[0];
        for(int i =0;i<n;i++)
            prefix = commonPrefixUtil(prefix, arr[i]);

        return prefix;
    }
    public static void main(String[] args) {
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geeker"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);
        System.out.println("ans = " + ans);
    }
}
