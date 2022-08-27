import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap();
        
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        int answer = 1;
        
        for(String kind : map.keySet()) {
            answer *= map.get(kind);
        }
        
        return answer - 1; // 아무것도 안입은 경우 -1
    }
}