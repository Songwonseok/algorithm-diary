class Solution {
    int m,n;
    
    public int orangesRotting(int[][] grid) {
        m = grid.length; 
        n = grid[0].length;
        int[] dirX = {-1,1,0,0}, dirY = {0,0,-1,1};
        
        int minuetes = 0;
        
        Queue<int[]> queue = new LinkedList();
        
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(grid[x][y] == 2) {
                    queue.add(new int[] {x, y, minuetes});
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = curr[0] + dirX[dir];
                int ny = curr[1] + dirY[dir];
                
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) 
                    continue;
                
                grid[nx][ny] = 2;
                queue.add(new int[] {nx, ny, curr[2] + 1});
                
                minuetes = Math.max(minuetes, curr[2] + 1);
            }
            
        }
        
        
        if(isAllRotten(grid)) {
            return minuetes;
        }
        
        return -1;
    }
    
    
    public boolean isAllRotten(int[][] grid) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}