import java.util.*;

class Solution {
    private static final int[] dirN = {1, 0, -1, 0};
    private static final int[] dirM = {0, 1, 0, -1};

    public int minTimeToReach(int[][] moveTime) {
        int maxN = moveTime.length - 1;
        int maxM = moveTime[0].length - 1;

        int[][] memo = new int[maxN + 1][maxM + 1];

        for(int i = 0; i <= maxN; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList();

        queue.add(new int[] {0, 0, 0});

        while(!queue.isEmpty()) {
            int[] curr= queue.poll();

            int n = curr[0];
            int m = curr[1];
            int t = curr[2];

            for(int i = 0; i < 4; i++) {
                int nextN = n + dirN[i];
                int nextM = m + dirM[i];

                if(nextN < 0 || nextM < 0 || nextN > maxN || nextM > maxM) {
                    continue;
                }

                int nextT = Math.max(moveTime[nextN][nextM] + 1, t + 1);
                
                if(memo[nextN][nextM] > nextT) {
                    memo[nextN][nextM] = nextT;
                    queue.add(new int[] {nextN, nextM, nextT});
                }
            }
        }

        return memo[maxN][maxM];
    }

}