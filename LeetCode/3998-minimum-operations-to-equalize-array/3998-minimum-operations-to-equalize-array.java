class Solution {
    public int minOperations(int[] nums) {
        int prev = nums[0];

        for(int num : nums) {
            if(num != prev) {
                return 1;
            }
        }

        return 0;
    }
}