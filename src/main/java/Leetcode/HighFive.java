package Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/high-five/
 * <p>
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * Note:
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
public class HighFive{

    private static void solve(List<List<Integer>> innerList) {

        Map<Integer, Integer> map = new HashMap<>();
        for(List list : innerList) {
            System.out.println("list"+list);
            System.out.println(list.get(0));
            if(!map.containsKey(list.get(0)))
            {
                map.put((Integer) list.get(0), (Integer) list.get(1));
            }
            else {

                Integer sum = map.get(list.get(0));
                
                map.put((Integer) list.get(0), sum);
            }


            System.out.println("map = " + map);
        }
        List<Integer>keys = (List<Integer>) map.keySet();
        
        for (Integer key : keys)
        {
          //  List<Integer>values = map.get(key);
           // System.out.println("values = " + values);

        }
        
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][] a= new int[1001][101];
        List<List<Integer>> innerList =  new ArrayList<>();
        innerList.add(Arrays.asList(1,91));
        innerList.add(Arrays.asList(1,92));
        innerList.add(Arrays.asList(2,93));
        innerList.add(Arrays.asList(2,97));
        innerList.add(Arrays.asList(1,60));
        innerList.add(Arrays.asList(2,77));
        innerList.add(Arrays.asList(1,65));
        innerList.add(Arrays.asList(1,87));
        innerList.add(Arrays.asList(1,100));
        innerList.add(Arrays.asList(2,100));
        innerList.add(Arrays.asList(2,77));
        System.out.println(innerList);
        solve(innerList);
    }

}
