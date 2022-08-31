class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) {
            return image;
        }
        
        Queue<Integer> queue = new LinkedList();
        int[] dirR = {-1, 1, 0 ,0}, dirC = {0, 0, -1, 1};
             
        int m = image.length;
        int n = image[0].length;
        
        int origin = image[sr][sc];
        
        image[sr][sc] = color;
        queue.add(sr * n + sc);
        
        while(!queue.isEmpty()) {
            int r = queue.peek() / n;
            int c = queue.poll() % n;
            
            for(int dir = 0; dir < 4; dir++) {
                int nr = r + dirR[dir];
                int nc = c + dirC[dir];
                
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || image[nr][nc] != origin) {
                    continue;
                }
                
                image[nr][nc] = color;
                queue.add(nr * n + nc);
                
            }
        }
        
        return image;
        
    }
}