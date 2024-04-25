import java.util.*;

class Solution {
    static final Map<String, Integer> mineralMap = Map.of("diamond", 25, "iron", 5, "stone", 1);
    static final int[] powerArr = {25, 5, 1};
    static int answer;
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        int size = minerals.length % 5 > 0 ? (minerals.length / 5) + 1 : minerals.length / 5;
        size = Math.min(Arrays.stream(picks).sum(), size);
        
        int[] acc = new int[size];
        
        perm(0, picks, acc, size, minerals);
        
        return answer;
    }
    
    
    public void perm(int depth, int[] picks, int[] acc, int size, String[] minerals) {
        if(depth == size) {
            int result = 0;
            
            for(int i =0; i < size; i++) {
                int power = powerArr[acc[i]];
                
                
                for(int j = i * 5; j < minerals.length && j < (i * 5) + 5; j++) {
                    int mineral = mineralMap.get(minerals[j]);
                    
                    if(power >= mineral) {
                        result++;
                        continue;
                    }
                    
                    result += mineral / power;
                }                
            }
            
            answer = Math.min(answer, result);
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] == 0) {
                continue;
            }
            
            acc[depth] = i;
            picks[i]--;
            perm(depth+1, picks, acc, size, minerals);
            picks[i]++;
        }
        
        
    }    
}