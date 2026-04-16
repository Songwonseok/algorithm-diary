import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomatos = new int[N][M];
		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				tomatos[i][j] = Integer.parseInt(st.nextToken());
				if (tomatos[i][j] == 1)
					que.add(i * M + j);
			}
		}
		int time = 0;
		int size = que.size();
		while (!que.isEmpty()) {
			time++;
			for (int t = 0; t < size; t++) {
				int curr = que.poll();
				int x = curr / M;
				int y = curr % M;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatos[nx][ny] == 0) {
						tomatos[nx][ny] = 1;
						que.add(nx * M + ny);
					}
				}
			}
			size = que.size();
		}
		boolean check = true;
		label: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatos[i][j] == 0) {
					check = false;
					break label;
				}
			}
		}

		if (check) {
			if(time ==0) System.out.println(time);
			else System.out.println(time-1);
		}
		else
			System.out.println(-1);

	}

}
