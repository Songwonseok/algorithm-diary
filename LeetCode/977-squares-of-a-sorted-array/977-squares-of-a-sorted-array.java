class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        
        int left = 0;
        int right = nums.length - 1;
        
        int index = nums.length - 1;
        
        while(index >= 0) {
            int leftPow = nums[left] * nums[left];
            int rightPow = nums[right] * nums[right];
            
            if(leftPow <= rightPow) {
                answer[index--] = rightPow;
                right--;
            }else {
                answer[index--] = leftPow;
                left++;
            }
        }
        
        
        return answer;
    }
}