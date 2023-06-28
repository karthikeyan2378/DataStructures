package Leetcode;

public class ContainerWithMInWater {
    public static int MinWater(int a[], int l)
    {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = l-1;
        while (left<right)
        {
            int width = right- left;

            ans = Math.max(width * Math.min(a[left], a[right]), ans);
            if(a[left]<a[right])
                left++;
            else
                right--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        int l = a.length;
        System.out.println("MinWater(a, l) = " + MinWater(a, l));

    }
}
