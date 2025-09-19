class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int count = 0;

        Queue<Integer> queue = new LinkedList();


        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
                max = Math.max(count, max);
                continue;
            }

            if(queue.size() < k) {
                count++;
                queue.add(i);
                max = Math.max(count, max);
                continue;
            }

            if(!queue.isEmpty()) {
                int left = queue.poll();

                count = i - left;
                queue.add(i);
                continue;
            }

            count = 0;
        }

        return max;
    }
}