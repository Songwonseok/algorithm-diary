class Solution {
    List<List<Integer>> answer;
    boolean[] visit;
    int[] nums, acc;
    int l;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        answer = new ArrayList();
        l = nums.length;
        acc = new int[l];
        visit = new boolean[l];
        
        perm(0);
        
        return answer;
    }
    
    
    public void perm(int depth){
        if(depth == l) {
            List<Integer> result = new ArrayList();
            
            for(int i = 0; i < l; i++) {
                result.add(acc[i]);
            }
            
            answer.add(result);
            
            return;
        }
        
        for(int i = 0; i < l; i++) {
            if(!visit[i]) {
                visit[i] = true;
                acc[depth] = nums[i];
                perm(depth+1);
                visit[i] = false;
            }
        }
    }
}