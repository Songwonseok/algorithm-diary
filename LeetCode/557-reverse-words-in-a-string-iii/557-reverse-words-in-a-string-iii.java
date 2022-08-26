class Solution {
    public void reverse(char[] word) {
        int left = 0;
        int right = word.length - 1;
        
        while(left < right) {
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            
            left++;
            right--;
        }
    }
    
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] answer = new String[words.length];
        
        
        for(int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            reverse(charArray);   
            
            answer[i] = new String(charArray);
        }
        
        return String.join(" ", answer);
    }
}