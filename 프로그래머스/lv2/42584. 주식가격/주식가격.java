import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int last = prices.length;
        int[] answer = new int[last];
        Stack<int[]> stack = new Stack();
        
        
        for(int sec = 1; sec <= last; sec++) {
            while(!stack.isEmpty() && stack.peek()[1] > prices[sec - 1]) {
                int[] curr = stack.pop();
                answer[curr[0] - 1] = sec - curr[0];
            }
            
            stack.push(new int[] {sec, prices[sec - 1]});
                  
        }
        
            while(!stack.isEmpty()) {
                int[] curr = stack.pop();
                answer[curr[0] - 1] = last - curr[0];
            }
                                  
        return answer;
    }
}