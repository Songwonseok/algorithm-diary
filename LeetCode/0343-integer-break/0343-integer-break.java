class Solution {
    public int integerBreak(int n) {
        // 2 = 1, 1 -> 1
        // 3 = 1 2 -> 2
        // 4 = 2 2 -> 4
        // 5 = 2 3 -> 6
        // 6 = 3 3 -> 9
        // 7 = 2 2 3 -> 12
        // 8 = 2 6 -> 18
        // 9 = 3 6 -> 27
        // 10 -> 36

        int[] dp = new int[59];
        dp[1] = 1;
        dp[2] = 2;

        if(n == 2) {
            return 1;
        }

        if(n == 3) {
            return 2;
        }

        for(int i = 2; i <= n; i++) {
            int max = 0;

            for(int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[i-j] * dp[j], max);
            }

            dp[i] = Math.max(max, i);
        }

        return dp[n];
    }
}