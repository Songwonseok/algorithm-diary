import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap();
        HashMap<String, Integer> idxMap = new HashMap();
        
        for(int i = 0; i < id_list.length; i++){
            reportMap.put(id_list[i], new HashSet<String>());
            idxMap.put(id_list[i], i);
        }
        
        for(String r : report) {
            String[] split = r.split(" ");
            reportMap.get(split[1]).add(split[0]);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> reportSet = reportMap.get(id_list[i]);
            int count = reportSet.size();
            
            if(count >= k) {
                for(String id : reportSet) {
                    answer[idxMap.get(id)]++;
                }
            }
            
        }
        
        return answer;
    }
}