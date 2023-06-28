package Leetcode;

public class UniquePathMem {
    public static int uniquePath(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        return uniquePath(m-1,n)+uniquePath(m,n-1);
    }
    public static void main(String[] args) {
        int path = uniquePath(3, 7);
        System.out.println(path);
    }
}
