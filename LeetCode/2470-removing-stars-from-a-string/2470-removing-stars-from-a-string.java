class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == '*') {
                stack.pop();
                continue;
            }

            stack.push(curr);
        }

        char[] array = new char[stack.size()];

        int index = stack.size() - 1;

        while(!stack.isEmpty()) {
            array[index--] = stack.pop();
        }

        return new String(array);
    }
}