class Solution {
    public int alternatingSubarray(int[] nums) {
        int acc = 1;
        int max = -1;
        int count = 1;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + acc == nums[i + 1]) {
                acc *= -1;
                count++;
                max = Math.max(count, max);

            }else if(nums[i] + 1 == nums[i + 1]) {
                count = 2;
                acc = -1;
            }else {
                acc = 1;
                count = 1;
            }
        }

        return max;
    }
}