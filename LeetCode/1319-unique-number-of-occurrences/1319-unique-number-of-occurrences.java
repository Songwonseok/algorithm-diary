import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        Set<Integer> set = new HashSet();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key :map.keySet()) { 
            if(set.contains(map.get(key))) {
                return false;
            }

            set.add(map.get(key));
        }

        return true;
    }
}