class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String token : tokens) {
            switch(token) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(a + b);
                    continue;
                }
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(b - a);
                    continue;
                }
                case "*": {
                    int a = stack.pop();
                    int b = stack.pop();

                    stack.push(a * b);
                    continue;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    continue;
                }
                default: 
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}