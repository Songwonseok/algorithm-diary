class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);

        PriorityQueue<int[]> pq = new PriorityQueue((o1, o2) -> Integer.compare(((int[])o2)[1], ((int[])o1)[1]));

        int prev = Integer.MAX_VALUE;
        int count = 0;

        for(int num : nums) {
            if(prev == Integer.MAX_VALUE || prev == num) {
                prev = num;
                count++;
                continue;
            }

            pq.add(new int[] {prev, count});
            count = 1;
            prev = num;
        }

        if(count > 0) {
            pq.add(new int[] {prev, count});
        }

        int[] answer = new int[k];

        for(int i = 0; i < k; i++) {
            answer[i] = pq.poll()[0];
        }

        return answer;
    }
}