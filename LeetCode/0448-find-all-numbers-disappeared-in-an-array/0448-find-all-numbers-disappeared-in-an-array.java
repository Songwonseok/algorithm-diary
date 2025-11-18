class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        int[] count = new int[n + 1];

        for(int num : nums) {
            count[num]++;
        }

        List<Integer> answer = new ArrayList();

        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                answer.add(i);
            }
        }

        return answer;
    }
}