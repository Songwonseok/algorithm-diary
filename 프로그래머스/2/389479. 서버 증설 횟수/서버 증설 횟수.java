class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        
        for(int i = 0; i < 24; i++) {
            int acceptablePlayer = servers[i] * m;
            
            if(players[i] > acceptablePlayer) {
                int expandCount = (players[i] - acceptablePlayer) / m;
                answer += expandCount;
                expandServers(servers, k, expandCount, i);
            }
            
        }
        
        return answer;
    }
    
    private void expandServers(int[] servers, int k, int count, int hours) {
        
        for(int i = hours; i < 24 && i < hours + k; i++) {
            servers[i] += count;
        }
        
    }
}