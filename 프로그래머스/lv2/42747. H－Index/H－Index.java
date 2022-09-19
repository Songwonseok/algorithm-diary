import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            int min = Math.min(citations.length - i, citations[i]);
            
            answer = Math.max(min, answer);
        }
        
        return answer;
    }
}