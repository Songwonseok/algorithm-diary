import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue();
        PriorityQueue<Integer> desc = new PriorityQueue(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] s = op.split(" ");
            
            switch(s[0]) {
                case "I":
                    asc.offer(Integer.parseInt(s[1]));
                    desc.offer(Integer.parseInt(s[1]));
                    break;
                case "D":
                    if(asc.size() == 0) {
                        continue;
                    }
                    
                    if(Integer.parseInt(s[1]) == 1) {
                        int number = desc.poll();
                        asc.remove(number);
                    }else {
                        int number = asc.poll();
                        desc.remove(number);
                    }
            }
        }
        
        int[] answer = new int[2];
        
        if(asc.size() == 0) {
            return answer;
        }
        
        answer[0] = desc.poll();
        answer[1] = asc.poll();
        
        return answer;
    }
}