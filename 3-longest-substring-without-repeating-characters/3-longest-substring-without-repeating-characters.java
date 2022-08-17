class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        
        int start = 0;
        int end = 0;
        
        int length = 0;
        int maxLength = 0;
        
        while(end < s.length() && start <= end) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                length++;
                end++;
                maxLength = Math.max(maxLength, length);
                continue;
            }
            
            set.remove(s.charAt(start));
            start++;
            length--;
        }
        
        return maxLength;
        
    }
}