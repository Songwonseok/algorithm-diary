import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        boolean[] visit = new boolean[people.length];
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            }else {
                right--;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}