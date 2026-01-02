class MyCircularDeque {
    private int capacity, size;
    private final Node head, tail;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }

        Node node = new Node(value);
        Node front = head.next;

        front.prev = node;
        head.next = node;

        node.next = front;
        node.prev = head;
         
        size++;

        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        Node node = new Node(value);

        Node last = tail.prev;

        tail.prev = node;
        last.next = node;

        node.prev = last;
        node.next = tail;

        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }

        Node front = head.next;

        head.next = front.next;
        front.next.prev = head;

        front.next = null;
        front.prev = null;
        size--;

        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        Node last = tail.prev;

        tail.prev = last.prev;
        last.prev.next = tail;

        last.next = null;
        last.prev = null;
        size--;
        
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }

        return head.next.value;
    }
    
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }

        return tail.prev.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    private static class Node {
        int value;
        Node prev, next;

        Node(int value) {
            this.value = value;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */