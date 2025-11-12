class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();

        String prefix = "";
        long num = x;

        if(x < 0) {
            prefix = "-";

            num *= -1;
        }

        String reverse = sb.append(num).reverse().toString();


        if(Long.parseLong(reverse) > Integer.MAX_VALUE) {
            return 0;
        }

        return Integer.parseInt(prefix + reverse);

    }
}