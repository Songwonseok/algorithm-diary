import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] temp;
	static int[][] k;
	static int[][] d;
	static int[] di = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dj = { 1, 0, -1, 0 }; // 우하좌상
	static boolean[] visit; // 우하좌상

	static Queue<Integer> que;
	static int min;
	static int N;
	static int M;
	static int K;
	static int cnt=0;
	
	
	
	
	
	public static void perm(int r) {
		if (r == K) {
			for(int i=0;i<arr.length;i++) {
				temp[i] = Arrays.copyOf(arr[i], arr[i].length);
			}
			for (int i = 0; i < K; i++) {
				rotation(k[i][0], k[i][1], k[i][2]);
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < M; j++) {
					sum += temp[i][j];
				}
				min = Math.min(sum, min);
			}
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visit[i]) {
				visit[i] = true;
				k[r][0] = d[i][0];
				k[r][1] = d[i][1];
				k[r][2] = d[i][2];
				perm(r+1);
				visit[i] = false;
			}
		}
	}

	public static void rotation(int r, int c, int s) {
		if (s == 0) {
			return;
		}
		int num = s+s;
		int nx = r - s;
		int ny = c - s;
		que.offer(temp[nx][ny]);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < num; j++) {
				nx = nx + di[i];
				ny = ny + dj[i];
				if (nx == r - s && ny == c - s)
					break;
				que.offer(temp[nx][ny]);
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < num; j++) {
				nx = nx + di[i];
				ny = ny + dj[i];
				temp[nx][ny] = que.poll();
			}
		}
		rotation(r, c, s - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new int[N][M];
		que = new LinkedList<>();
		visit = new boolean[K];
		d = new int[K][3];
		k = new int[K][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int r = 0;
		int c = 0;
		int s = 0;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(bf.readLine(), " ");
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			if (r - s < 0 || r - s >= N || c - s < 0 || c - s >= M)
				continue;
			d[k][0] = r;
			d[k][1] = c;
			d[k][2] = s;
		}
		int sum = 0;
		min = Integer.MAX_VALUE / 2;
		perm(0);
		System.out.println(min);
	}
}
