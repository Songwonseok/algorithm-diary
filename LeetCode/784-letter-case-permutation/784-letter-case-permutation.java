class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList();
        
        
        perm(0, s, new boolean[s.length()], answer);
        
        return answer;
    }
    
    public void perm(int index, String s, boolean[] isUpper,List<String> answer) {
        if(index == s.length()) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < s.length(); i++) {
                if(isUpper[i]) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    continue;
                }
                 
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            answer.add(sb.toString());
            return;
        }
        
        if(s.charAt(index) - 'A' >= 0) {
            isUpper[index] = true;
            perm(index+1, s, isUpper, answer);
            isUpper[index] = false;
        }
        
        perm(index+1, s, isUpper, answer);      
    }
}