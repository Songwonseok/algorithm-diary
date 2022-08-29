import java.util.*;

class Solution {
    int[] values;
    
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList();
        values = new int[10];
        
        for(int idx = 0; idx < priorities.length; idx++) {
            queue.add(idx);
            values[priorities[idx]]++;
        }
        
        int answer = 0;
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();

            if(!isPrintable(priorities[idx])) {
                queue.add(idx);
                continue;
            }
            
            answer++;
            values[priorities[idx]]--;
            
            if(idx == location) {
                break;
            }
        }
        
        return answer;
    }
    
    public boolean isPrintable(int priority) {
        for(int i = priority + 1; i <= 9; i++) {
            if(values[i] > 0) {
                return false;
            }
        }
        
        return true;
    }
}