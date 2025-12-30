class LRUCache {
    private final Map<Integer, Node> cache;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();

        this.head = new Node(); // first
        this.tail = new Node(); // last

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        updateOrder(key);

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;

        if(!cache.containsKey(key)) {
            node = new Node(key, value);
            cache.put(key, node);
        }else {
            node = cache.get(key);
            node.value = value;
        }

        updateOrder(key);
        
        eviction();
    }

    private void updateOrder(int key) {
        Node node = cache.get(key);

        if(node.prev != null && node.next != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        Node last = tail.prev;

        node.prev = last;
        last.next = node;
        
        node.next = tail;
        tail.prev = node;
    }

    private void eviction() {
        if(cache.size() <= capacity) {
            return;
        }

        Node removed = head.next;

        head.next = removed.next;
        removed.next.prev = head;
    
        cache.remove(removed.key);
    }


    static class Node {
        public int key;
        public int value;

        public Node prev;
        public Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */