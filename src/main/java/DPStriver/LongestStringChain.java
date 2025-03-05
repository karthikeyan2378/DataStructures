package DPStriver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {
    public static boolean compare(String s1, String s2)
    {
        if(s1.length()!= s2.length()+1)
            return false;


        int first =0;
        int second =0;

        while(first<s1.length())
        {
            if(second<s2.length() &&  s1.charAt(first)== s2.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }

        return first==s1.length() && second ==s2.length();
    }

    // Custom comparison function for sorting strings by length
    public static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public static  int longestStrChain(String[] nums) {
        int n = nums.length;
        List<String> arr = Arrays.asList(nums);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        arr.sort(comp);
        int max = 1;
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <i; prev_index ++){

                if(compare(arr.get(i), arr.get(prev_index)) && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int max =  longestStrChain(new String[]{"xb", "xbc", "cxbc", "pcxbc", "pcxbcf"});
        System.out.println("max = " + max);
    }
}
