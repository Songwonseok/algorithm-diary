class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                answer = mid + 1;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
}