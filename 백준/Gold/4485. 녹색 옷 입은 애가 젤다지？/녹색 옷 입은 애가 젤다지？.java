import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc=1;

		while (true) {
			int N = Integer.parseInt(bf.readLine().trim());
			if(N==0) break;
			int[][] map = new int[N][N];
			int[][] memo = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine().trim());
				Arrays.fill(memo[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] { 0, 0, map[0][0] });
			memo[0][0] = map[0][0];
			int min = Integer.MAX_VALUE;
			while (!que.isEmpty()) {
				int[] curr = que.poll();
				int x = curr[0];
				int y = curr[1];
				int value = curr[2];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && value + map[nx][ny] < memo[nx][ny]) {
						memo[nx][ny] = value + map[nx][ny];
						que.add(new int[] { nx, ny, value + map[nx][ny] });
					}
				}
			}
			System.out.println("Problem "+tc+": "+memo[N-1][N-1]);
			tc++;
		}
	}

}
