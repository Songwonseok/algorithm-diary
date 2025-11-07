class Solution {
    public int longestContinuousSubstring(String s) {
        char prev = s.charAt(0);
        int count = 1;
        int answer = 1;

        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(prev - 'a' + 1 == curr - 'a') {
                count++;
            }else {
                count = 1;
            }

            answer = Math.max(count, answer);
            prev = curr;
        }

        return answer;
    }
}