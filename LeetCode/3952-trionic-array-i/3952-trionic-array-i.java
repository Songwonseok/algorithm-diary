class Solution {
    public boolean isTrionic(int[] nums) {
        int idx = 0;
        int start1 = 0;
        while(idx + 1 < nums.length && nums[idx] < nums[idx + 1]) idx++;

        if(idx == start1) {
            return false;
        }
        int start2 = idx;

        while(idx + 1 < nums.length && nums[idx] > nums[idx + 1]) idx++;

        if(idx == start2) {
            return false;
        }

        int start3 = idx;

        while(idx + 1 < nums.length && nums[idx] < nums[idx + 1]) idx++;

    
        return start3 < idx && idx == nums.length - 1;
    }
}