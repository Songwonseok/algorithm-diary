class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();

        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int mod = sum % k;

            if(mod == 0 && i != 0) {
                return true;
            }

            if(map.containsKey(mod)) {
                if(i - map.get(mod) >= 2) {
                    return true;
                }
            }else {
                map.put(mod, i);
            }

        }   

        return false;
    }
}