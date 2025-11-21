class Solution {
    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();

        int side = 1;
        boolean hasSide = false;

        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if(c == ' ') {
                if(sb.length() > 0 || hasSide) {
                    break;
                }
            }else if(c == '+' || c == '-') {
                if(sb.length() > 0 || hasSide) {
                    break;
                }

                hasSide = true;

                side = c == '-' ? -1 : 1;
            }else if(isNumber(c)) {
                sb.append(c);
            }else {
                break;
            }

        }

        if(sb.length() == 0) {
            return 0;
        }

        double result = Double.parseDouble(sb.toString()) * side;

        
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }else {
            return (int) result;
        }

    }

    private boolean isNumber(char c) {
        int ascii = c - '0';

        return 0 <= ascii && ascii <= 9;
    }
}