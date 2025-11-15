class Solution {
    public String reformatNumber(String number) {
        String reformat = number.replace(" ", "").replace("-", "");

        StringBuilder sb = new StringBuilder();

        if(reformat.length() <= 3) {
            return reformat;
        }

        while(reformat.length() > 0) {
            String prefix = sb.isEmpty() ? "" : "-";

            if(reformat.length() > 4) {
                sb.append(prefix).append(reformat.substring(0, 3));
                reformat = reformat.substring(3);
            }else if(reformat.length() == 4){
                sb.append(prefix).append(reformat.substring(0, 2)).append("-").append(reformat.substring(2));
                break;
            }else {
                sb.append(prefix).append(reformat);
                break;
            }

        }

        return sb.toString();
    }
}