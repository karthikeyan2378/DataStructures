package LeetCode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurence {
    public static void main(String[] args) {
        int arr[] = {1,2,2,1,1,3};
        System.out.println("solution = " + solution(arr));
    }

    private static boolean solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i], 1);
            }
            else
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        System.out.println("map.values() = " + map.values());
        Set<Integer> s =  new HashSet<>(map.values());
        if(map.values().size() == s.size())
            return true;

        return false;
    }
}
