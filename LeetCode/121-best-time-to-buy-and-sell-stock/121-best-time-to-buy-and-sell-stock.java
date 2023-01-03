class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] min = new int[length];
        int[] max = new int[length];
        
        // min : 왼쪽에서부터 가장 최소값 누적
        // max : 오른쪽부터 가장 최대값 누적
        
        min[0] = prices[0];
        max[length - 1] = prices[length - 1];
        
        for(int i = 1; i < length; i++) {
            min[i] = Math.min(prices[i], min[i-1]);
        }
        
        for(int i = length -2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i + 1]);
        }
        
        int answer = 0;
        
        for(int i = 0; i < length; i++) {
            answer = Math.max(max[i] - min[i], answer);
        }
        
        return answer;
    }
}