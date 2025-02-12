package LeetCode75;

import java.util.*;
import java.util.stream.Collectors;

public class StringCompression {
    public static void main(String[] args) {
        char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        solution(chars);

    }

    private static void solution(char[] chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i]))
            {
                map.put(chars[i], 1);
            }
            else
            {
                map.put(chars[i], map.get(chars[i])+1);
            }
            
        }
        System.out.println("map = " + map);
        StringBuilder set = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            set.append(entry.getKey());
            set.append(entry.getValue());
        }

        System.out.println("set = " + set);
        char[] res = set.toString().toCharArray();
        Set<Character>finalRes = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            finalRes.add(res[i]);
        }

        System.out.println("finalRes = " + finalRes);
    }
}
