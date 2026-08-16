class MyQueue {
    private Stack<Integer> temp;
    private Stack<Integer> queue;

    public MyQueue() {
        temp = new Stack();
        queue = new Stack();
    }
    
    public void push(int x) {
        while(!queue.isEmpty()) {
            temp.push(queue.pop());
        }


        queue.push(x);

        while(!temp.isEmpty()) {
            queue.push(temp.pop());
        }

    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */