class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        
        while(left <= right) {
            int waterHeight;
            int width = right - left;
            
            if(height[left] > height[right]) {
                waterHeight = height[right];
                right--;
            }else if(height[left] < height[right]){
                waterHeight = height[left];
                left++;
            }else {
                waterHeight = height[left];
                right--;
                left++;
            }
            
            area = Math.max(area, width * waterHeight);
        }
        
        return area;
        
    }
}