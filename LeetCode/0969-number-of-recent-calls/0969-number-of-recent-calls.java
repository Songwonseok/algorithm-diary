class RecentCounter {
    private Deque<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList();
    }
    
    public int ping(int t) {
        requests.addLast(t);

        while(requests.peekFirst() < t - 3000) {
            requests.pollFirst();
        }

        return requests.size();

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */