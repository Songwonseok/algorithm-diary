import java.io.*;
import java.util.*;

public class Main {
	static int N,M,max;
	static int[][] map;
	static int[] dx = {-1,0,1,0},dy= {0,1,0,-1};
	static boolean[][] v;
	
	public static void solve(int x,int y,int r,int sum) {
		if(r==3) {
			max = Math.max(max, sum);
			return;
		}
		for(int dir=0;dir<4;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx>=0 && nx <N && ny >=0 && ny<M && !v[nx][ny]) {
				v[nx][ny] = true;
				solve(nx,ny,r+1,sum+map[nx][ny]);
				v[nx][ny] = false;
			}
		}
	}
	public static void solve2(int x,int y) {
		int num = map[x][y];
		for(int dir=0;dir<4;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx >= 0 && nx <N && ny >=0 && ny <M) {
				int nx2= x+dx[(dir+1)%4];
				int ny2= y+dy[(dir+1)%4];
				int nx3= x+dx[(dir+2)%4];
				int ny3= y+dy[(dir+2)%4];
				if(nx2>=0 && nx3>=0 && ny2>=0 && ny3>=0 
						&&nx2 <N && nx3 <N && ny2 <M && ny3<M) {
					int sum = num;
					sum += map[nx][ny]+map[nx2][ny2]+map[nx3][ny3];
					max=Math.max(max, sum);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max=0;
		v= new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!v[i][j]) {
					v[i][j] = true;
					solve(i,j,0,map[i][j]);
					solve2(i,j);
					v[i][j] = false;
				}
			}
		}
		System.out.println(max);
		
		
	}
}