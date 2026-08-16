class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        map = new HashMap();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        removeNode(node);
        addToHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;

        if(map.containsKey(key)) {
            node = map.get(key);
            node.val = value;

            removeNode(node);
        }else {
            node = new Node(key, value);
            map.put(key, node);
        }


        addToHead(node);

        if(map.size() > capacity) {
            Node removed = tail.prev;
            
            removeNode(removed);
            map.remove(removed.key);         
        }        
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        Node next = head.next;

        node.prev = head;
        node.next = next;

        head.next = node;
        next.prev = node;
    }

    class Node {
        Node next;
        Node prev;
        int val;
        int key;

        Node() {}

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */