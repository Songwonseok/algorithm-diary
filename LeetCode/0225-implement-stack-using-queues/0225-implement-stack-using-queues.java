class MyStack {
    private Queue<Integer> temp;
    private Queue<Integer> stack;

    public MyStack() {
        temp = new LinkedList();
        stack = new LinkedList();
    }
    
    public void push(int x) {
        temp.add(x);

        while(!stack.isEmpty()) {
            temp.add(stack.poll());
        }

        while(!temp.isEmpty()) {
            stack.add(temp.poll());
        }

    }
    
    public int pop() {
        return stack.poll();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */