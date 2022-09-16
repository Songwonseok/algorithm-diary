import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
		int pivot = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}

			return Integer.compare(o1[0], o2[0]);
		});


		for (int[] job : jobs) {
			pq.add(job);
		}

		while (!pq.isEmpty()) {
			int[] job = pq.poll();
            
            if(pivot < job[0]) {
                pivot = job[0];
            }
            
			pivot += job[1];
			answer += pivot - job[0];

			int finalPivot = pivot;
			PriorityQueue<int[]> temp = new PriorityQueue((Comparator<int[]>)(o1, o2) -> {
				if (o1[0] <= finalPivot && o2[0] <= finalPivot) {
					return Integer.compare(o1[1], o2[1]);
				}

				return Integer.compare(o1[0], o2[0]);
			});

			while (!pq.isEmpty()) {
				temp.add(pq.poll());
			}
			pq = temp;
		}

		return answer / jobs.length;
    }
}