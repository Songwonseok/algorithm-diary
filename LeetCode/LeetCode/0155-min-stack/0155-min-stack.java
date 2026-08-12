class MinStack {
    private Stack<int[]> stack;
    private Integer minValue;

    public MinStack() {
         stack = new Stack();
         minValue = null;
    }
    
    public void push(int value) {
        if(minValue != null) {
            minValue = Math.min(minValue, value);
        }else {
            minValue = value;
        }
        
        stack.push(new int[] {value, minValue});
    }
    
    public void pop() {
        stack.pop();

        if(stack.isEmpty()) {
            minValue = null;
        }else {
            minValue = stack.peek()[1];
        }
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */