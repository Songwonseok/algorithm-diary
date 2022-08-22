class Solution {   
    int[][] grid;
    boolean[][] visit;
    int m,n;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visit = new boolean[m][n];

        
        int answer = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visit[i][j]) {
                    answer = Math.max(answer, dfs(i, j));
                }
                
            }
        }
        
        return answer;
    }
    
    public int dfs(int r, int c) {  
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1 || visit[r][c])
            return 0;

        visit[r][c] = true;
        
        return 1 + dfs(r - 1, c) + dfs(r + 1, c) + dfs(r, c - 1) + dfs(r, c + 1);
        
    }
}