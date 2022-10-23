class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int large = Math.max(sides[0], sides[1]);
        int small = Math.min(sides[0], sides[1]);
        
        // (large + small) - (large - small) - 1
        answer = 2 * small - 1 ;
        
        
        return answer;
    }
}