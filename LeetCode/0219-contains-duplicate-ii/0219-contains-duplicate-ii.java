class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet();

        int maxSize = k + 1;

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if(set.size() >= maxSize) {
                set.remove(nums[i - k]);
            }

        }

        return false;
    }
}