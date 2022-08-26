class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int start = 0 + k % length;
        
        int[] temp = new int[length];
        
        for(int i = 0; i < length; i++) {
            
            temp[(start+i) % length] = nums[i];
        }
        
        
        for(int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
        
    }
}