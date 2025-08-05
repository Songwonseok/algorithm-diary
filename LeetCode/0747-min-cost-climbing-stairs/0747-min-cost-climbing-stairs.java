class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        for(int i = 2; i < cost.length; i++) {
            int prev1 = i - 1;
            int prev2 = i - 2;

            dp[i] = Math.min(dp[prev1] + cost[prev1], dp[prev2] + cost[prev2]);
        }


        return Math.min(dp[dp.length - 1] + cost[dp.length - 1], dp[dp.length - 2] + cost[dp.length - 2]);
    }
}