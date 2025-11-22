class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] v = stack.pop();

                answer[v[0]] = i - v[0]; 
            }

            stack.push(new int[] {i, temperatures[i]});                
        }

        return answer;
    }
}