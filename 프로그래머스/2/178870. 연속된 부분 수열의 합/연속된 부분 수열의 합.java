class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int[] answer = {-1, 1_000_000};
        
        int sum = sequence[left];
        
        while(left <= right && right < sequence.length) {
            
            if(sum >= k) {
                
                if(sum == k && answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left++];
                continue;
            }
            
            if(sum < k && ++right < sequence.length) {
                sum += sequence[right];
            }
            
        }
        
        
        
        return answer;
    }
}