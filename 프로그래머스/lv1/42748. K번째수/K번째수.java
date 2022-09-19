import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0] - 1;
            int j = commands[idx][1] - 1;
            int k = commands[idx][2] - 1;
            
            int[] temp = new int[j - i + 1];
            
            for(int x = 0; x <= j - i; x++) {
                temp[x] = array[i + x];
            }
            
            Arrays.sort(temp);
            
            answer[idx] = temp[k];
        }
        
        
        return answer;
    }
}