class Solution {
    public List<String> partitionString(String s) {
        List<String> answer = new ArrayList();

        Set<String> set = new HashSet();

        String segment = "";

        for(char c : s.toCharArray()) {
            segment += c;

            if(!set.contains(segment)) {
                set.add(segment);
                answer.add(segment);
                segment = "";
            }
        }

        return answer;
    }
}