package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElement {
    public static void freq(int nums[], int k)
    {
/*        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        System.out.println("map = " + map);
        for (int key : map.keySet())
        {
            int value =
        }*/
    }
    public static void main(String[] args) {
        int nums[]={1,1,1,2,2,3};
        int k =2;
        freq(nums, k);
    }
}
