import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int totalWeight = 0;
		int time = 1;
		int[] trucks = new int[n];
		Queue<int[]> bridge = new LinkedList<int[]>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		
		while(index < n) {
			if (totalWeight + trucks[index] <= L) {
				bridge.add(new int[] { trucks[index], time + w });
				time++;
				totalWeight += trucks[index++];
			} else {
				int[] pass = bridge.poll();
				totalWeight -= pass[0];
				time = pass[1];
			}
			
			while(!bridge.isEmpty() && time >= bridge.peek()[1]) {
				int[] pass = bridge.poll();
				time = pass[1];
				totalWeight -= pass[0];
			}
			
		}
		
		while(!bridge.isEmpty()) {
			int[] pass = bridge.poll();
			time = pass[1];
		}
		
		System.out.println(time);
	}

}