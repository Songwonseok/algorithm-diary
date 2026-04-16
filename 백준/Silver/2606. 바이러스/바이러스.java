import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vertices = Integer.parseInt(br.readLine());
		int lines = Integer.parseInt(br.readLine());
		int[][] graph = new int[vertices+1][vertices+1];
		boolean[] visit = new boolean[vertices+1];
		
		for(int i=0;i<lines;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		
		int start = 1;
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int next=1;next<=vertices;next++) {
				if(graph[curr][next] == 1 && !visit[next]) {
					count++;
					visit[next] = true;
					queue.add(next);
				}
			}
		}
		System.out.println(count);
	}
}