class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;

        double max = 0;
        double sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }


        System.out.println("sum: " + sum);
        max = sum / k;

        while(right < nums.length - 1) {
            sum -= nums[left++];
            sum += nums[++right];

            max = Math.max(max, sum / k);
        } 
        

        return max;
    }
}