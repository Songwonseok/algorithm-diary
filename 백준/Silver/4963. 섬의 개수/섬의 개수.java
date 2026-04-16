

import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		while(true) {
			String line =bf.readLine();
			if(line != null)
				st = new StringTokenizer(line);
			else
				break;
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if(H==0 && W ==0)
				break;
			int[][] map = new int[H][W];
			boolean[][] visit = new boolean[H][W];
			int cnt = 0;
			int[] di = {-1,-1,0,1,1,1,0,-1};//시계방향
			int[] dj = {0,1,1,1,0,-1,-1,-1};//시계방향
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> que = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						que.offer(new int[] { i, j });
						visit[i][j] = true;
						cnt++;

						while (!que.isEmpty()) {
							int[] curr = que.poll();
							
							for(int k=0;k<8;k++) {
								int nx = curr[0]+di[k];
								int ny = curr[1]+dj[k];
								if(nx >=0 && nx < H && ny >=0 && ny < W && !visit[nx][ny] && map[nx][ny]==1) {
									visit[nx][ny] = true;
									que.offer(new int[] {nx,ny});
								}
							}
						}
					}
				}
			}
			
			System.out.println(cnt);
			
		}

	}

}
