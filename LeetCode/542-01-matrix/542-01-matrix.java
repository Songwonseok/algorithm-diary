class Solution {
    int m,n;
    int[][] dist, mat;
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int[][] updateMatrix(int[][] mat) {
        this.m=mat.length;
        this.n=mat[0].length;
        this.dist=new int[m][n];
        this.mat = mat;
        
        for(int[] ar:dist){
             Arrays.fill(ar,Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    dfs(i,j,0);
                }
            }
         }
    
         return dist;
    }
    
    public void dfs(int x, int y, int prev) {
        dist[x][y] = prev;
        
        
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || mat[nx][ny] == 0 || dist[nx][ny] <= prev + 1) {
                continue;
            }
            
            dfs(nx, ny, prev + 1);
        }
        
    }
}