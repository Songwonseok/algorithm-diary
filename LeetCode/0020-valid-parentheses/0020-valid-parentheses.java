import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }

                stack.pop();
            }else if(c == '}') {
                if(stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }else if (c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }
}