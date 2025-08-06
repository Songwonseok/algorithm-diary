import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = Set.of('a','e','i','o','u');
    public int maxVowels(String s, int k) {
        char[] word = s.toCharArray();
    
        int count = 0;
        int left = 0;
        int right = k -1;

        for(int i = 0; i < k; i++) {
            if(VOWELS.contains(word[i])) {
                count++;
            }
        }

        int max = count;

        while(right < word.length - 1) {
            if(VOWELS.contains(word[left++])) {
                count--;
            }

            if(VOWELS.contains(word[++right])) {
                count++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}