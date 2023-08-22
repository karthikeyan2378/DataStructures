package LeetCode75;

public class IsSubSequence {
    public static void main(String[] args) {
        String s = "rjufvjafbxnbgriwgokdgqdqewn";
        String t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        solution(s, t);
    }

    private static void solution(String s, String t) {
        boolean b = false;

        int count = 0;
        for (int i = 0; i < t.length(); i++) {

                if(s.charAt(count) == t.charAt(i)) {
                    System.out.println("s.charAt(i) = " + s.charAt(count));
                    i++;
                    count++;
                }
               if (count == s.length())
                   System.out.println("count = " + count);
        }


    }
}
