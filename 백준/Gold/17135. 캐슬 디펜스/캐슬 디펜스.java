import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] archer;
	static int N, M, D, max;
	static boolean[] v;

	public static void comb(int start, int r) {
		if (r == 3) {
			game();
			return;
		}
		for (int i = start; i < M; i++) {
			if (!v[i]) {
				v[i] = true;
				archer[r] = i;
				comb(i, r + 1);
				v[i] = false;
			}
		}
	}

	public static boolean checkEndgame(int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[3];
		v = new boolean[M];
		map = new int[N][M];
		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	public static ArrayList<int[]> findEnemy(int[][] temp, Point a) {
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 1) {
					if (Math.abs(a.x - i) + Math.abs(a.y - j) <= D) {
						list.add(new int[] { i, j, (Math.abs(a.x - i) + Math.abs(a.y - j)) });
					}
				}
			}
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[2], o2[2]);
			}
		});
		return list;
	}

	public static void game() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++)
			temp[i] = map[i].clone();
		Point[] archers = new Point[3];
		HashSet<Integer> set = new HashSet<>();
		int kill = 0;
		for (int i = 0; i < 3; i++) {
			archers[i] = new Point(N, archer[i]);
		}

		while (!checkEndgame(temp)) {
			// 궁수 공격
			for (int i = 0; i < 3; i++) {
				ArrayList<int[]> list = findEnemy(temp, archers[i]);
				if (list.size() != 0) {
					set.add(list.get(0)[0] * M + list.get(0)[1]);
				}
			}
			if (set.size() != 0) {
				kill += set.size();
				Iterator<Integer> it = set.iterator();
				while (it.hasNext()) {
					int enemy = it.next();
					temp[enemy / M][enemy % M] = 0;
				}
				set.clear();
			}
			// 이동
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 1) {
						if (i == N - 1) {
							temp[i][j] = 0;
						} else {
							temp[i + 1][j] = 1;
							temp[i][j] = 0;
						}
					}
				}
			}
		}
		max = Math.max(max, kill);
	}

}