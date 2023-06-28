package Leetcode;

//increment right pointer
//when price of left>price of right put replace the left value to current value
//apply sliding window
public class StockProblem {
    public static void main(String[] args) {
        int pricesOfStock[] = {7,6,5,4,3};
        int maxProfit =0;
        int left = 0;
        int right =1;
        while (left<pricesOfStock.length && right<pricesOfStock.length) {
        if(pricesOfStock[left]<pricesOfStock[right]) {
            int currSum = pricesOfStock[right]-pricesOfStock[left];
            maxProfit = Math.max(maxProfit, currSum);

        }
        else {
            left=right;
        }
        right++;
        }
        System.out.println("maxProfit = " + maxProfit);
    }
}
