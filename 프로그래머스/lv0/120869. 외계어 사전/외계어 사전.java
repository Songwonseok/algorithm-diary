class Solution {
    public int solution(String[] spell, String[] dic) {
        int count = 0;
        
        for(String word : dic) {
            if(word.length() != spell.length) {
                continue;
            }
            
            String temp  = word;
            
            for(String s : spell) {
                temp = temp.replaceFirst(s, "");
            }
            
            if(temp.length() == 0) {
                count++;
            }
            
        }
        
        if(count == 0) {
            return 2;
        }
        
        return 1;
    }
}