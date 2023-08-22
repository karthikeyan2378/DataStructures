package LeetCode75;

public class LargestAttitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        solution(gain);
    }

    private static void solution(int[] gain) {
        
   
        int max =0;
        int currentMax = 0;
        for (int i = 0; i < gain.length; i++) {
             currentMax = gain[i]+currentMax;
             max =Math.max(max, currentMax);
        }
        System.out.println("max = " + max);
    }
}
