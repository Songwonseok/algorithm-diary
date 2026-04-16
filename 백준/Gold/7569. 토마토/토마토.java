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
		int H = Integer.parseInt(st.nextToken());
		int[][][] tomatos = new int[H][N][M];
		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 }, dh = { 1, -1 };
		Queue<int[]> que = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					tomatos[h][i][j] = Integer.parseInt(st.nextToken());
					if (tomatos[h][i][j] == 1)
						que.add(new int[] { h, i, j });
				}
			}
		}
		int time = 0;
		int size = que.size();
		while (!que.isEmpty()) {
			time++;
			for (int t = 0; t < size; t++) {
				int curr[] = que.poll();
				int h = curr[0];
				int x = curr[1];
				int y = curr[2];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatos[h][nx][ny] == 0) {
						tomatos[h][nx][ny] = 1;
						que.add(new int[] { h, nx, ny });
					}
				}
				for (int i = 0; i < 2; i++) {
					int nh = h + dh[i];
					if (nh >= 0 && nh < H && tomatos[nh][x][y] == 0) {
						tomatos[nh][x][y] = 1;
						que.add(new int[] { nh, x, y });
					}
				}
			}
			size = que.size();
		}
		
		boolean check = true;
	label: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomatos[h][i][j] == 0) {
						check = false;
						break label;
					}
				}
			}
		}
		if (check) {
			if (time == 0)
				System.out.println(time);
			else
				System.out.println(time - 1);
		} else
			System.out.println(-1);

	}

}
