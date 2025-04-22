import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesMap = new HashMap();
        
        for(String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 1) + 1); // 안입는 경우 포함
        }
        
        for(String key : clothesMap.keySet()) {
            answer *= clothesMap.get(key);
        }
        
        
        return answer - 1; // 아무것도 안입은 경우 제외
    }
}