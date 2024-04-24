import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        
        Map<String, Integer> indexMap = new HashMap();
    
        
        for(int i = 0; i < size; i++) {
            indexMap.put(friends[i], i);
        }
        
        int[][] accGift = new int[size][size];
        int[] giftScore = new int[size];
        
        
        for(String gift: gifts) {
            String[] names = gift.split(" ");
            
            int senderIdx = indexMap.get(names[0]);
            int recipientIdx = indexMap.get(names[1]);
            
            accGift[senderIdx][recipientIdx]++;
            
            giftScore[senderIdx]++;
            giftScore[recipientIdx]--;
        }
        
        int[] result = new int[size];
        
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                
                if(accGift[i][j] == accGift[j][i]) {
                    
                    if(giftScore[i] >  giftScore[j]) {
                        result[i]++;
                    }
                    
                    if(giftScore[i] < giftScore[j]) {
                        result[j]++;
                    }
                    
                    continue;
                }
                
                if(accGift[i][j] > accGift[j][i]) {
                    result[i]++;
                }else {
                    result[j]++;
                }
            }
        }
        
        
        return Arrays.stream(result).max().orElse(0);
    }
}