import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            }

            return Integer.compare(o1[1], o2[1]);
        });

        int answer = 0;
        int prev = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(prev > intervals[i][0]) {
               answer++;
               continue; 
            }

            prev = intervals[i][1];
        }

        return answer;

    }
}