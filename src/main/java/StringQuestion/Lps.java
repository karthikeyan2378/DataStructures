package StringQuestion;

public class Lps {
    public static int lpsCalculate(String d){
        int maxlength =0;
        String maxString ="";
        for(int i =0;i<d.length();i++)
        {
            for(int j =i;j<d.length();j++)
            {
                if(ispalindrome(d.substring(i,j)))
                {
                    int currentLength = d.substring(i,j).length();
                    if(maxlength<currentLength)
                    {
                        maxlength = currentLength;
                        maxString = d.substring(i,j);
                    }
                }
            }
        }
        System.out.println("maxString = " + maxString);
        return maxlength;
    }
    
    public static boolean ispalindrome(String d)
    {
        int i = 0, j = d.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (d.charAt(i) != d.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String d = "babad";
        System.out.println("lpsCalculate(d) = " + lpsCalculate(d));

    }
}
