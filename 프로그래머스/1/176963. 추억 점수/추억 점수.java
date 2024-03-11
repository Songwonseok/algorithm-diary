import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList();
        
        Map<String, Integer> map = new HashMap();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(String[] people : photo) {
            int sum = 0;
            
            for(String person : people) {
                sum += map.getOrDefault(person, 0);
            }
            
            answer.add(sum);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}