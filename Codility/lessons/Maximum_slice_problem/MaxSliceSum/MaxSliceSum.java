class Solution {
    public int solution(int[] A) {
        int N = A.length;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            sum += A[i];

            max = Math.max(max, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return max;

    }
}
