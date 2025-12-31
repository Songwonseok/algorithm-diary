class LFUCache {
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap;
    private int capacity, minFreq, count;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        freqMap = new HashMap();     
        minFreq = 1;   
        count = 0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        countUp(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            countUp(node);
            return;
        }

        if(capacity == count) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node remove = list.findLruNode();
            cache.remove(remove.key);
            count--;
        }
        
        minFreq = 1;

        Node node = new Node(key, value);
        if(!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new DoublyLinkedList());
        }

        freqMap.get(node.freq).addNode(node);
        cache.put(key, node);
        count++;
    }

    private void countUp(Node node) {
        DoublyLinkedList list = freqMap.get(node.freq);

        list.removeNode(node);
        node.freq++;

        if(!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new DoublyLinkedList());
        }

        freqMap.get(node.freq).addNode(node);

        if(list.isEmpty() && minFreq == node.freq - 1) {
            minFreq = node.freq;
        }
    }

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        Node findLruNode() {
            Node node = tail.prev;

            removeNode(node);
            return node;
        }

        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            node.prev = null;
            node.next = null;
        }

        void addNode(Node node) {
            Node nextNode = head.next;

            node.next = nextNode;
            nextNode.prev = node;

            head.next = node;
            node.prev = head;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */