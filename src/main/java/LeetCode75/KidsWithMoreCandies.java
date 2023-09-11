package LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithMoreCandies {
    public static void main(String[] args) {
        int[] candies = {2, 8, 7};
        int extraCandies = 1;
        solution(candies, extraCandies);
    }

    private static List<Boolean> solution(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, i);
        }
        List<Boolean>maxCandies = new ArrayList<>();
        for (int candy :  candies)
        {
            if(candy + extraCandies >= max){
                maxCandies.add(true);
            }else{
                maxCandies.add(false);
            }
        }


        System.out.println("maxCandies = " + maxCandies);
        return maxCandies;
    }
}
