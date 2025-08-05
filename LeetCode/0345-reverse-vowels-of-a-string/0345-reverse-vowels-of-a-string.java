import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = Set.of('A','E','I','O','U');

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;


        while(left < right) {
            while(left < right && !isVowel(charArray[left])) {
                left++;
            }

            while(left < right && !isVowel(charArray[right])) {
                right--;
            }

            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            left++;
            right--;
        }

        return new String(charArray);
    }

    public boolean isVowel(char c) {
        return VOWELS.contains(Character.toUpperCase(c));
    }
}