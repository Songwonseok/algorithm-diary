class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        String subStr = str1Length < str2Length ? str1 : str2;

        String answer = "";

        while(subStr.length() > 0) {
            int length = subStr.length();
            
            if(str1Length % length != 0 || str2Length % length != 0) {
                subStr = subStr.substring(0, length - 1);
                continue;
            }
            
            if(str1.equals(subStr.repeat(str1Length / length)) 
            && str2.equals(subStr.repeat(str2Length / length))) {
                answer = subStr;
                break;
            }

            subStr = subStr.substring(0, length - 1);   
        }

        return answer;
    }
}