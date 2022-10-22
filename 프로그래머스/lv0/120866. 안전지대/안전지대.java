class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}, dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        int lengthX = board.length;
        int lengthY = board[0].length;
        boolean[][] safety = new boolean[lengthX][lengthY];
        
        for(int x = 0; x < lengthX; x++) {
            for(int y = 0; y < lengthY; y++) {
                if(board[x][y] == 1) {
                    safety[x][y] = true;
                    
                    for(int d = 0; d < 8; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        
                        if(nx < 0 || nx >= lengthX || ny < 0 || ny >= lengthY) {
                            continue;
                        }
                        
                        safety[nx][ny] = true;
                    }
                    
                    
                    
                }
            }
        }
        
        
        for(int x = 0; x < lengthX; x++) {
            for(int y = 0; y < lengthY; y++) {
                if(!safety[x][y]) {
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}