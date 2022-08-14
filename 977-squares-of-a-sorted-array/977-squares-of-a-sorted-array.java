class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        
        int left = 0;
        int right = nums.length - 1;
        
        int index = nums.length - 1;
        
        while(index >= 0) {
            int leftPow = (int)Math.pow(nums[left], 2);
            int rightPow = (int)Math.pow(nums[right], 2);
            
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