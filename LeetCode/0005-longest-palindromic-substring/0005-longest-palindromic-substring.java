class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            int odd =  checkLength(s, i, i);
            int even =  checkLength(s, i, i+1);

            int len = Math.max(odd, even);

            if(len > end - start) {
                if(len % 2 == 0) {
                    start = i - (len / 2) + 1;
                }else {
                    start = i - (len / 2);
                }
                end = i + (len / 2) + 1;
            }           
        }

        return s.substring(start, end);
    }

    private int checkLength(String s, int l, int r) {
        int len = 0;

        while(l >= 0 && r < s.length()) {
            if(s.charAt(l) == s.charAt(r)) {
                len = r - l + 1;
            }else {
                break;
            }

            l--;
            r++;
        }

        return len;
    }
}