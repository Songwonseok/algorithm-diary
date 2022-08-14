class Solution {
    public void rotate(int[] nums, int k) {
        int start = 0 + k % nums.length;
        
        int[] answer = nums.clone();
        
        for(int i = 0; i < nums.length; i++) {
            int index = (start + i) % nums.length;
            
            nums[index] = answer[i];
        }
        
        
    }
}