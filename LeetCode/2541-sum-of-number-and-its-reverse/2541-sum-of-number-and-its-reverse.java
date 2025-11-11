class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        int part = num / 2;

        while(part <= num) {
            int compare = num - part;
        
            StringBuilder sb = new StringBuilder(String.valueOf(part));

            if(Integer.parseInt(sb.reverse().toString()) == compare) {
                return true;
            }

            part++;
        }

        return false;
    }
}