import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = Set.of('A','E','I','O','U');

    public String reverseVowels(String s) {
        Stack<Character> vowelStack = new Stack();
        char[] charArray = s.toCharArray();

        for(char c : charArray) {
            if(isVowel(c)) {
                vowelStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c : charArray) {
            if(isVowel(c)) {
                sb.append(vowelStack.pop());
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public boolean isVowel(char c) {
        return VOWELS.contains(Character.toUpperCase(c));
    }
}