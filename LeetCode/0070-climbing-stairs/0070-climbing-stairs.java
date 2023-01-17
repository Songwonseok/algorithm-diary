class Solution {
    public int climb(int[] dp, int n) {
        if(n > 0 && dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climb(dp, n - 1) + climb(dp, n - 2);

        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;

        return climb(dp, n);
    }
}