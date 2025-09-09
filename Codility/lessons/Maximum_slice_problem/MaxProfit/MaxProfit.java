class Solution {
    public int solution(int[] A) {
        int max = 0;
        int curr = Integer.MAX_VALUE;
    
        for(int i = 0; i < A.length; i++) {
            if(A[i] - curr < 0) {
                curr = A[i];
                continue;
            }

            max = Math.max(max,  A[i] - curr);
        }

        return max;
    }
}
