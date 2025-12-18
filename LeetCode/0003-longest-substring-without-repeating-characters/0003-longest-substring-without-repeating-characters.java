class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        char[] arr = s.toCharArray();
        int max = 0;
        int left = 0;

        for(int right = 0; right < arr.length; right++) {
            if(!set.contains(arr[right])) {
                set.add(arr[right]);
                max = Math.max(max, set.size());
            }else {
                while(arr[left] != arr[right]) {
                    set.remove(arr[left++]);
                }

                set.remove(left++);
                set.add(arr[right]);
            }
        }

        return max;
    }
}