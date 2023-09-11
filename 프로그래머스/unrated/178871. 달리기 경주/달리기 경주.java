import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            answer[i] = players[i];
        }
        
        for(String calling: callings) {
            int idx = map.get(calling);
            
            String temp = answer[idx - 1];
            answer[idx - 1] = answer[idx];
            answer[idx] = temp;
            
            map.put(calling, idx - 1);
            map.put(temp, idx);
        }
        
        
        return answer;
    }
}