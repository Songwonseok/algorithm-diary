class Solution {
    public boolean isPalindrome(int x) {
         if(x < 0) {
             return false;
         }
        
        String str = Integer.toString(x);
        int length = str.length();
        
        if(length > 1 && str.charAt(length - 1) == '0') {
            return false;
        }
        
        int left = length / 2;
        int right = length / 2;
        
        if(length % 2 == 0) {
            left--;
        }
        
        while(left >= 0) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            
            left--;
            right++;
        }
        
        return true;
    }
}