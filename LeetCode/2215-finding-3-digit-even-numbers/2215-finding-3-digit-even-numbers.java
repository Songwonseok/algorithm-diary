import java.util.*;

class Solution {
    
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> answerList = new HashSet();
        Arrays.sort(digits);
        
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == 0) {
                continue;
            }

            for(int j = 0; j < digits.length; j++) {
                if(i == j) {
                    continue;
                }


                for(int k = 0; k < digits.length; k++) {
                    if(k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    sb.append(digits[i]);
                    sb.append(digits[j]);
                    sb.append(digits[k]);

                    answerList.add(Integer.parseInt(sb.toString()));
                }
            }
        }

        return answerList.stream().mapToInt(v -> v).sorted().toArray();
    }

    
}