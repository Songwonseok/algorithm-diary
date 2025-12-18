class Solution {
    public boolean isPalindrome(String s) {
        List<Character> result = s.toLowerCase().chars()
            .mapToObj(c -> (char)c)
            .filter(Solution::isValid)
            .toList();
        
        int left = (result.size() - 1) / 2;
        int right = result.size() % 2 == 0 ? left + 1 : left;

        while(left >= 0 && right < result.size()) {
            if(result.get(left) != result.get(right)) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }

    public static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}