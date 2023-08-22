package LeetCode75;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int [] num ={0,1,0,3,12};
        solution(num);
        solution2(num);
    }

    private static void solution2(int[] num) {
        int i = 0;
        for (int j = 0; j < num.length; j++) {
            if(num[j]!=0)
                num[i++] = num[j];


        }
        System.out.println("Arrays.toString(num) = " + Arrays.toString(num));

        while (i<num.length)
        {
            num[i++] =0;
        }
        System.out.println("Arrays.toString1(num) = " + Arrays.toString(num));
    }

    private static void solution(int[] num) {
        int snowBallSize = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] == 0 )
                snowBallSize++;
            else
            {
                int t = num[i];
                num[i] =0;
                num[i-snowBallSize] =t;
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }

        System.out.println(Arrays.toString(num));
    }
}
