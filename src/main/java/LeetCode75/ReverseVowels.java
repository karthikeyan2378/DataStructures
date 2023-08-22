package LeetCode75;

public class ReverseVowels {
    public static void main(String[] args) {
        String a = "Sex at noon taxes.";
        solution(a);
    }

    private static void solution(String a) {
        char [] c = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] =='o' || c[i] == 'u' ||
                    c[i] == 'A' || c[i] == 'E' || c[i] == 'I' || c[i] =='O' || c[i] == 'U'){
                sb.append(c[i]);
                c[i] = 'a';
            }
        }

        System.out.println("sss" + new String(c));;
        System.out.println("sb.reverse().toString() = " + sb.reverse().toString());;

        int k =0;
        for (int i = 0; i < c.length; i++) {
            if(c[i] == 'a')
            {
                c[i] = sb.toString().charAt(k);
                k++;
            }
        }

        System.out.println("new String(c) = " + new String(c));
    }
}
