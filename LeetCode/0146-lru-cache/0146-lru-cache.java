class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);

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
            removeNode(node);
        }

        addToHead(node);

        if(cache.size() > capacity) {
            Node removeTarget = tail.prev;

            removeNode(removeTarget);
            cache.remove(removeTarget.key);
        }

    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    private void addToHead(Node node) {
        Node next = head.next;

        node.next = next;
        node.prev = head;

        next.prev = node;
        head.next = node;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

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