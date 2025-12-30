class Solution {
    private static int M, N;
    private static int[] dirX = {-1, 1, 0, 0}, dirY = {0, 0, -1, 1};
    
    public int numIslands(char[][] grid) {
        M = grid.length;
        N = grid[0].length;

        boolean[][] visit = new boolean[M][N];

        int count = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && grid[i][j] == '1') {
                    visit[i][j] = true;
                    explore(i,j,grid, visit);
                    count++;
                }
            }
        }

        return count;
    }

    public void explore(int x, int y, char[][] grid, boolean[][] visit) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }

            if(!visit[nx][ny] && grid[nx][ny] == '1') {
                visit[nx][ny] = true;
                explore(nx, ny, grid, visit);
            }
        }
    }
}