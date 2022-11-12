class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        
label: for(int i = s.length(); i >= 1; i--) {
            
            for(int j = 0; j + i <= s.length(); j++) {
                String substr = s.substring(j, j + i);
                
                if(checkValid(substr)) {
                    answer = substr;
                    break label;
                }
                
            }
            
        }
        
        return answer;
    }
    
    public boolean checkValid(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
        
    }
}