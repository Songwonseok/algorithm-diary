class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total = 0L;
        int hire = 0;

        int left = 0;
        int right = costs.length - 1;

        PriorityQueue<Integer> leftQueue = new PriorityQueue();
        PriorityQueue<Integer> rightQueue = new PriorityQueue();

        while(hire < k) {
            while(left <= right && leftQueue.size() < candidates) {
                leftQueue.add(costs[left++]);
            }

            while(left <= right && rightQueue.size() < candidates) {
                rightQueue.add(costs[right--]);
            }

            int first = !leftQueue.isEmpty() ? leftQueue.poll() : Integer.MAX_VALUE;
            int last = !rightQueue.isEmpty() ? rightQueue.poll() : Integer.MAX_VALUE;
            int use = 0;

            if(first <= last) {
                total += first;

                use = first;
                if(last != Integer.MAX_VALUE) {
                    rightQueue.add(last);
                }

            }else {
                total += last;
                use = last;
                if(first != Integer.MAX_VALUE) {
                    leftQueue.add(first);
                }
            }


            hire++;
        }

        return total;

    }
}