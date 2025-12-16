class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap();

        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                sum[i] = nums[i];
            }else {
                sum[i] = sum[i - 1] + nums[i];
            }

            if(sum[i] == k) {
                count++;
            }

            if(map.containsKey(sum[i] - k)) {
                count += map.get(sum[i] - k);
            }

            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);   
            
        }

        

        return count;
    }
}