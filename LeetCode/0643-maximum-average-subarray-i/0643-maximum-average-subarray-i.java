class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = k - 1;

        int sum = 0;
        

        for(int i = l; i <= r; i++) {
            sum += nums[i];
        }

        int max = sum;

        while(r < nums.length - 1) {
            sum -= nums[l++];
            sum += nums[++r];

            max = Math.max(sum, max);
        }

        return ((double) max) / k;
    }
}