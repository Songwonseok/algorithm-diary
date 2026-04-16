
import java.io.*;
import java.util.*;

public class Main {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[] end;
	static int min, R, C;
	static boolean v[][];
	static Queue<int[]> que;
	

	public static char[][] fire(char[][] map) {
		
		int size = que.size();
		char[][] nmap = new char[R][C];
		for(int i=0;i<R;i++) {
			nmap[i] = Arrays.copyOf(map[i], C);
		}
		if(que.isEmpty())
			return nmap;
		for (int i = 0; i < size; i++) {
			int[] curr = que.poll();
			for (int j = 0; j < 4; j++) {
				int nx = curr[0] + di[j];
				int ny = curr[1] + dj[j];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && (nmap[nx][ny] == '.'||nmap[nx][ny] == 'S')) {
					nmap[nx][ny] = '*';
					que.offer(new int[] { nx, ny });
				}
			}
		}
		return nmap;
	}

	public static void bfs(Queue<int[]> q, char[][] map, int time) {
		
		
		char[][] nmap = fire(map);
		int size = q.size();
		if(size==0)
			return;
		for(int t=0;t<size;t++) {
			int[] curr = q.poll();
			if (map[curr[0]][curr[1]] == 'D') {
				min = Math.min(min, time);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + di[i];
				int ny = curr[1] + dj[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && !v[nx][ny] && (nmap[nx][ny] == 'D' || nmap[nx][ny] == '.')) {
					v[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		bfs(q,nmap,time+1);
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		v = new boolean[R][C];
		int[] start = new int[2];
		end = new int[2];
		min = 987654321;
		que = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'D') {
					end[0] = i;
					end[1] = j;
				} else if (map[i][j] == '*') {
					que.offer(new int[] { i, j });
				}
			}
		}
		v[start[0]][start[1]] =true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0],start[1]});
		bfs(q,map,0);

		if (min != 987654321) {
			System.out.println(min);
		} else {
			System.out.println("KAKTUS");
		}

	}

}
