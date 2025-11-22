class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String answer = "";

        for(int l = 0; l < s.length(); l++) {
            for(int r = s.length() -1; r >= l; r--) {
                if(answer.length() > r - l + 1) {
                    break;
                }

                String sub = s.substring(l, r + 1);

                if(isPalindromic(sub) && answer.length() < sub.length()) {
                    answer = sub;
                }
            }
        }

        return answer;
    }

    private boolean isPalindromic(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l <= r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}