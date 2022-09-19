import java.util.*;

class Solution {
    public String solution(int[] numbers) {       
        String[] sArray = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            sArray[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(sArray, (o1, o2) -> {
            return -(o1 + o2).compareTo(o2+o1);
        });
        
        String answer = String.join("", sArray);
        
        if(sArray[0].equals("0")) {
            return "0";
        }
        
        return answer;
    }
}