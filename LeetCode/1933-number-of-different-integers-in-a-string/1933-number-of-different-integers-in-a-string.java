import java.math.BigInteger;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<BigInteger> set = new HashSet();


        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();

            while(i < word.length() && isNumber(word.charAt(i))) {
                sb.append(word.charAt(i));
                i++;
            }

            if(sb.isEmpty()) {
                continue;
            }

            set.add(new BigInteger(sb.toString()));
        }

        return set.size();
    }

    private boolean isNumber(char c) {
        int ascii = c - '0';

        return 0 <= ascii && ascii <= 9;
    }
}