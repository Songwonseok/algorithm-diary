class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void moveZeroes(int[] nums) {
        for(int left = 0; left < nums.length - 1; left++) {
            
            for(int right = left + 1; right < nums.length; right++) {
                if(nums[left] == 0 && nums[right] != 0) {
                    swap(nums, left, right);
                    break;
                }
            }
        }
        
    }
}