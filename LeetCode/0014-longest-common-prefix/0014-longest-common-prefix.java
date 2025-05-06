import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        char[] maximumPrefix = strs[0].toCharArray();


        label: for(int i = 0; i < maximumPrefix.length; i++) {
            char curr = maximumPrefix[i];

            for(int j = 0; j < strs.length; j++) {
                if(strs[j].length() < i -1 || strs[j].charAt(i) != curr) {
                    break label;
                }

            }

            sb.append(curr);
        }

        return sb.toString();

    }
}