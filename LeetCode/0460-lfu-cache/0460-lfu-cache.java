class LFUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LFUCache(int capacity) {
        cache = new HashMap();

        this.capacity = capacity;

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
        node.count++;

        removeLruNode(node);
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
            removeLruNode(node);
            node.value = value;
        }

        if(cache.size() > capacity) {
            Node removeNode = findRemoveNode();
            
            cache.remove(removeNode.key);
            removeLruNode(removeNode);
        }

        node.count++;
        addToHead(node);
    }

    private Node findRemoveNode() {
        Node node = tail;

        int min = Integer.MAX_VALUE;
        Node removeNode = null;

        while(node.prev != head) {
            node = node.prev;

            if(node.count < min) {
                removeNode = node;
                min = node.count;
            }
        }

        return removeNode;
    }


    private void removeLruNode(Node node) {
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
        next.prev = node;
        
        node.prev = head;
        head.next = node;
    }

    static class Node {
        int key, value, count;

        Node prev, next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            count = 0;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */