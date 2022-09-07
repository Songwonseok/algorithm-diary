public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= 31; i++) {
            int binary = 1 << i;
            
            if((n & binary) == binary) {
                sb.append("1");
            }else {
                sb.append("0");
            }
        }
        
        return (int)Long.parseLong(sb.toString(), 2);
    }
}