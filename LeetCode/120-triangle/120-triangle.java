class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.get(triangle.size() - 1).size()][];
        
        for(int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        
        for(int i = dp.length - 1; i > 0; i--) {
            for(int j = 0; j < dp[i].length - 1; j++) {
                dp[i - 1][j] = dp[i - 1][j] + Math.min(dp[i][j], dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}