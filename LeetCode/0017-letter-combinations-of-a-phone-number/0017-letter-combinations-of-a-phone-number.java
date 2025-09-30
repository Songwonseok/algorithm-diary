class Solution {
    private static final Map<Integer, String> NUMBER_MAP = Map.of(
        2, "abc",
        3, "def",
        4, "ghi",
        5, "jkl",
        6, "mno",
        7, "pqrs",
        8, "tuv",
        9, "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList();

        if(digits.length() == 0) {
            return answer;
        }

        comb(answer, "", digits, 0);

        return answer;
    }

    private void comb(List<String> result, String acc, String digits, int depth) {
        if(digits.length() == depth) {
            result.add(acc);
            return;
        }

        int number = digits.charAt(depth) - '0';

        char[] charArray = NUMBER_MAP.get(number).toCharArray();

        for(char ch : charArray) {
            comb(result, acc + ch, digits, depth + 1);
        }
    }
}