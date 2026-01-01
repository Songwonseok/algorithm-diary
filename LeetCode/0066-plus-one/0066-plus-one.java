class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        List<Integer> reverse = new ArrayList();
        
        int plus = 1;

        for(int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i];

            if(num + plus == 10) {
                reverse.add(0);
            }else {
                reverse.add(num + plus);
                plus = 0;
            }
        }

        if(plus == 1) {
            reverse.add(plus);
        }

        int[] answer = new int[reverse.size()];

        int diff = reverse.size() - 1;

        for(int i = diff; i >= 0; i--) {
            answer[diff - i] = reverse.get(i);
        }

        return answer;
    }
}