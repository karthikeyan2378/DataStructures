package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int a[] = {2,7,11,15};
        System.out.println("a = " + Collections.singletonList(sum(a, 9)));
    }

    private static int[] sum(int[] a, int target) {

        Map<Integer, Integer>map = new HashMap<>();


        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(target-a[i])) {
                return new int[]{map.get(target - a[i]), i};
            }
            map.put(a[i], i);
        }
        System.out.println("map = " + map);

        return new int[]{};
    }
}
