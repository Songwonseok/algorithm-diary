import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
		int offset = 0;

		Arrays.sort(jobs, (Comparator<int[]>)(o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}

			return Integer.compare(o1[0], o2[0]);
		});

		PriorityQueue<int[]> pq = new PriorityQueue((Comparator<int[]>)(o1, o2) -> Integer.compare(o1[1], o2[1]));

		int index = 0;

		while(true) {
			while(index < jobs.length && jobs[index][0] <= offset) {
				pq.offer(jobs[index++]);
			}
            
            if(pq.size() == 0) {
                offset = jobs[index][0];
                continue;
            }

			int[] job = pq.poll();
            offset += job[1];
            answer += offset - job[0];
            
            if(index == jobs.length && pq.size() == 0){
                break;
            }
		}

		return answer / jobs.length;
    }
}