package INterview;

public class StringAdd {
    public static void main(String[] args) {
        String a = "11";
        String b = "123";

        int i = a.length()-1;
        int j = b.length()-1;

        int carry =0;
        StringBuilder stringBuilder = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = digitA + digitB + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);

            i--;
            j--;
        }
        System.out.println("stringBuilder.reverse() = " + stringBuilder.reverse());
    }
}
