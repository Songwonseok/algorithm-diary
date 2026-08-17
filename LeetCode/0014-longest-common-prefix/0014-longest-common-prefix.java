class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];

        StringBuilder sb = new StringBuilder();

    loop: for(int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);

            for(int j = 1; j < strs.length; j++) {
                String str = strs[j];

                if(str.length() <= i || str.charAt(i) != c) {
                    break loop;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}