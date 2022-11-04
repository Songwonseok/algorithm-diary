import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        boolean[] visit = new boolean[people.length];
        Arrays.sort(people);
        int curr = 0;
        int right = people.length;
        
        while(curr < people.length) {
            if(visit[curr]) {
                curr++;
                continue;
            }
            
            if(people[curr] > limit / 2) {
                answer++;
                curr++;
                continue;
            }
            
            for(int i = right - 1; i > curr ; i--) {
                if(visit[i]) 
                    continue;
                
                if(people[i] + people[curr] <= limit) {
                    visit[i] = true;
                    right = i;
                    break;
                }
            }
            
            visit[curr] = true;
            answer++;
        }
        
        
        return answer;
    }
}