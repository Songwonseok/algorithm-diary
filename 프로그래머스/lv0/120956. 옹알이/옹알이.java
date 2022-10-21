class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling) {
            if(isPossible(word)) {
                answer++;
            }    
        }
        
        return answer;
    }
    
    public boolean isPossible(String word) {
        String[] possibleWords = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < possibleWords.length; i++) {
            word = word.replace(possibleWords[i], Integer.toString(i));
        }
        
        char prev = '-';
        
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            
            if(curr < '0' || curr > '3') {
                return false;
            }
            
            if(prev == curr) {
                return false;
            }
            
            prev = curr;
        }
        
        return true;
    }
}