import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            String curr = phone_book[i];
            String next = phone_book[i + 1];
            
            if(next.startsWith(curr)) {
                return false;
            }
        }
        
        return answer;
    }
}