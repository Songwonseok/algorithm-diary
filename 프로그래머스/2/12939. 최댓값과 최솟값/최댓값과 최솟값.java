class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        
        String[] array = s.split(" ");
        
        for(String num : array) {
            max = Math.max(Integer.parseInt(num), max);
            min = Math.min(Integer.parseInt(num), min);
        }
        
        return min + " " + max;
    }
}