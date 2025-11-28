class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;

        for(int i = 0 ; i < arr.length; i++) {
            Set<Character> set = new HashSet();

            for(int j = i; j < arr.length; j++) {
                if(set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);    
            }

            max = Math.max(max, set.size());
        }

        return max;
    }
}