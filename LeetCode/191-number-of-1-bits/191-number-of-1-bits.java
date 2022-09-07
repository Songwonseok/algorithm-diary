public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i <= 31; i++) {
            int digit = 1 << i;
            
            if((n & digit) == digit) {
                count++;
            }
        }
        
        return count;
    }
}