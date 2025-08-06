import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] splits = s.split(" ");

        List<String> answer = new ArrayList();

        for(int i = splits.length -1; i >= 0; i--) {
            if(splits[i].length() == 0) {
                continue;
            }
            answer.add(splits[i]);
        }


        return String.join(" ", answer);
    }
}