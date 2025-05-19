class Solution {
    public void dfs(int start,int[][] computers, boolean[] v){
        v[start] = true;
        
        for(int i = 0; i < computers[start].length; i++) {
            if(computers[start][i] == 1 && !v[i]) {
                dfs(i, computers, v);
            }            
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];
        
        for(int i=0;i<computers.length;i++){
            if(!v[i]){
                dfs(i,computers,v);
                answer++;
            }
        }
        return answer;
    }
}