class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : nums) {
            pq.add(num);
        }

        int answer = 0;

        while(k > 0) {
            answer = pq.poll();
            k--;
        }


        return answer;
    }
}