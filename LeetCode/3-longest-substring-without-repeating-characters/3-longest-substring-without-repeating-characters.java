class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding window 알고리즘 적용
        HashMap<Character, Integer> map = new HashMap();
        
        int start = 0;
        int end = 0;

        int maxLength = 0;
        
        while(end < s.length()) {
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            
            while(map.size() < end - start + 1) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if(map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                    start++;
                }
            
            maxLength = Math.max(map.size(), maxLength);
            end++;
        }
        
        return maxLength;
        
    }
}