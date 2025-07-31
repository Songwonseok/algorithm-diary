class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;


        while(right < nums.length) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
                right++;
            }else {
                right++;
            }
        }
    }
}