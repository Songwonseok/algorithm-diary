class Solution {
    public boolean isPowerOfTwo(int n) {
        for(int i = 0; i <= 31; i++) {
            int pow = 1 << i;
            
            if(pow == n) {
                return true;
            }
            
            if(pow > n) {
                break;
            }
        }
        
        return false;
    }
}