class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> stack = new Stack();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] <= stack.peek()[1]) {
                int[] val = stack.pop();

                answer[val[0]] = prices[val[0]] - prices[i];
            }

            stack.push(new int[] {i, prices[i]});
        }

        while(!stack.isEmpty()) {
            int[] val = stack.pop();
            answer[val[0]] = val[1];
        }

        return answer;
    }
}