class Solution {
    public int singleNumber(int[] nums) {
        // XOR 사용
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            answer ^= nums[i]; 
        }
        
        return answer;
    }
}