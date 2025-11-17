class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] answer = new int[n];

        dp1[0] = nums[0];
        dp2[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            dp1[i] = dp1[i - 1] * nums[i];
        }

        for(int i = n - 2; i > 0; i--) {
            dp2[i] = dp2[i + 1] * nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                answer[i] = dp2[i + 1];
                continue;
            }

            if(i == n - 1) {
                answer[i] = dp1[i - 1];
                continue;
            }

            answer[i] = dp1[i - 1] * dp2[i + 1];
        }

        return answer;
        
    }
}