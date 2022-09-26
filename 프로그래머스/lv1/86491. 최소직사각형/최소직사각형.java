class Solution {
    public int solution(int[][] sizes) {
        int maxHeight = 0;
        int maxWidth = 0;
        
        for(int[] size : sizes) {
            int height = Math.max(size[0], size[1]);
            int width = Math.min(size[0], size[1]);
            
            maxHeight = Math.max(height, maxHeight);
            maxWidth = Math.max(width, maxWidth);
        }
        
        return maxHeight * maxWidth;
        
    }
}