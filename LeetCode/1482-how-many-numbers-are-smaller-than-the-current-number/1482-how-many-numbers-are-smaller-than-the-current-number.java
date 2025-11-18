class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int maxValue = 0;

        for(int num : nums) {
            count[num]++;
        }

        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i]; j++) {
                answer[i] += count[j];
            }
        }

        return answer;
    }
}