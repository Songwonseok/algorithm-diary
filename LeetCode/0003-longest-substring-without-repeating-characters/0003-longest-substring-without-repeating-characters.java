class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;

        Set<Character> set = new HashSet();
        char[] cArr = s.toCharArray();

        for(int i = 0; i < cArr.length; i++) {
            char c = cArr[i];

            if(!set.contains(c)) {
                set.add(c);
                max = Math.max(max,set.size());
                continue;
            }


            while(cArr[start] != c) {
                set.remove(cArr[start++]);
            }

            start++;
        }

        return max;

    }
}