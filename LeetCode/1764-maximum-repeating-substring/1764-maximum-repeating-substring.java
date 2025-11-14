class Solution {
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int length = sequence.length() - word.length() + 1;

        for(int i = 0; i < length; i++) {
            
            int start = i;
            int count = 0;

            while(start < length) {
                boolean isRepeat = true;
                
                for(int j = 0; j < word.length(); j++) {
                    if(sequence.charAt(start + j) != word.charAt(j)) {
                        isRepeat = false;
                        break;
                    }
                }

                if(!isRepeat) {
                    break;
                }

                
                count++;
                max = Math.max(max, count);
                start += word.length();
            }

        }

        return max;

    }
}