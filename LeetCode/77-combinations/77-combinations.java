class Solution {
    List<List<Integer>> answer;
    boolean[] visit;
    int n, k;
    
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList();
        visit = new boolean[n+1];
        this.n = n;
        this.k = k;
        
        comb(0, 1);
        
        return answer;
    }
    
    
    public void comb(int depth, int start){
        if(depth == k) {
            List<Integer> result = new ArrayList();
            
            for(int i = 1; i <= n; i++) {
                if(visit[i]) {
                    result.add(i);
                }
            }
            
            answer.add(result);
            
            return;
        }
        
        for(int i = start; i <= n; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    comb(depth+1, i + 1);
                    visit[i] = false;
                }
            }
    }
}