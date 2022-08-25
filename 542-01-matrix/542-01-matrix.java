class Solution {
    int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0},};
    public void dfs(int[][]graph,int[][]dist,int u,int v,int prev){
        dist[u][v]=prev;
        for(int i=0;i<4;i+=1){
            int x=u+comOfAdj[i][0],y=v+comOfAdj[i][1];
            if((x>=0&&x<graph.length) && (y>=0 && y<graph[0].length)&& graph[x][y]!=0 && (dist[x][y]>prev+1)){
                 dfs(graph,dist,x,y,prev+1);
            }
               
        }
    }
    public int[][] updateMatrix(int[][] mat) {
         int m=mat.length,n=mat[0].length;
         int [][]dist=new int[m][n];
         for(int []ar:dist)
             Arrays.fill(ar,Integer.MAX_VALUE);
        
         for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
                if(mat[i][j]==0){
                    dfs(mat,dist,i,j,0);
                }
            }
         }
    
         return dist;
    }
}