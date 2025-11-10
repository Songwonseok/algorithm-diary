class Solution {
    private static int INIT_VALUE = 'a' - 'a' - 1;

    public List<String> stringSequence(String target) {
        List<String> answer = new ArrayList();

        String acc = "";
        int prevAscii = INIT_VALUE;

        
        while(answer.isEmpty() || !target.equals(answer.get(answer.size() - 1))) {
            int idx = acc.length();

            char targetChar = target.charAt(idx);
            
            if((char)(prevAscii + 'a') == 'z') {
                prevAscii = INIT_VALUE;
            }

            char currChar = (char)(prevAscii + 1 + 'a');

            answer.add(acc + currChar);

            if(prevAscii + 1 == targetChar - 'a') {
                prevAscii = INIT_VALUE;
                acc = acc + currChar;
            }else {
                prevAscii++;
            }
        }

        return answer;
    }
}