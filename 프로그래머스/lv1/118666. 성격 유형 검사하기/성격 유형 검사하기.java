import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            
            if(choices[i] <= 4) {
                map.put(a, map.getOrDefault(a, 0) + (4 - choices[i]));
            }else {
                map.put(b, map.getOrDefault(b, 0) + (choices[i] - 4));
            }          
        }
        
        StringBuilder answer = new StringBuilder();
        
        char[][] categories = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        for(char[] category : categories) {
            Arrays.sort(category);
            
            int value1 = map.getOrDefault(category[0], 0);
            int value2 = map.getOrDefault(category[1], 0);

            if(value1 >= value2) {
                answer.append(category[0]);
            }else {
                answer.append(category[1]);
            }
            
        }
        
        return answer.toString();
    }
}