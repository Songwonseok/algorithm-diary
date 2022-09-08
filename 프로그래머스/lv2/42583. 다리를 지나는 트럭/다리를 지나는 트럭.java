import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int days = 0;
        int currWeight = 0;
        
        Queue<Integer> truck = new LinkedList(); // 무게, 들어온 일 수 
        Queue<int[]> bridge = new LinkedList();
        
        for(int tw : truck_weights) {
            truck.add(tw);
        }
        
        while(!truck.isEmpty()) {
            days++;
            
            if(!bridge.isEmpty() && bridge.peek()[0] == days) {
                currWeight -= bridge.poll()[1];
            }
            
            if(currWeight + truck.peek() > weight) {
                continue;
            }
            
            int truckWeight = truck.poll();
            currWeight += truckWeight;
            bridge.add(new int[] {days + bridge_length, truckWeight});
        }
        
        while(!bridge.isEmpty()) {
            days = bridge.poll()[0];
        }
        
        return days;
    }
}