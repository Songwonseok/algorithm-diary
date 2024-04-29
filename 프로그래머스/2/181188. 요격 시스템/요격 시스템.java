import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

		Arrays.sort(targets, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		
		double missile = -1;
		
		for(int[] target : targets) {
			if(missile < target[0]) {
				answer++;
				
				missile = target[1] - 0.5;
			}
			
		}

		return answer;
    }
}