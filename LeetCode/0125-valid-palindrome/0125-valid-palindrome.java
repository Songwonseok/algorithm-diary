class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] arr = s.toCharArray();

        for(int i = 0; i < s.length() / 2; i++) {
            if(arr[i] != arr[s.length() - i - 1]) {
                return false;
            }
        }

        return true;
    }
}