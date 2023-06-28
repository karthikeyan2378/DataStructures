package StringQuestion;



public class MinShifts {

    public static void main(String[] args) {
        String x = "kitten";
        String y = "sitting";
        System.out.println("dist() = " + dist(x, x.length(), y, y.length()));
    }

    private static int dist(String x, int length, String y, int length1) {
       /* either of the string is empty means return other string length CASE1*/
        if(length == 0)
            return length1;
        if(length1 == 0)
            return length;

        int cost = x.charAt(length-1)==y.charAt(length1-1)?0:1;
 return 0;
    }
}
