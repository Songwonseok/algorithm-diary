class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int maxValue = 0;

        for(int num : nums) {
            count[num]++;
        }

        int[] small = new int[101];

        for(int i = 1; i <= 100; i++) {
            small[i] += small[i - 1] + count[i - 1];
        }

        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            answer[i] = small[nums[i]];
        }

        return answer;
    }
}