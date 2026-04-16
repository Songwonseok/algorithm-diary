
import java.io.*;
import java.util.*;

public class Main{
	static int[] dx = {0,1,1}, dy = {1,1,0}; //우, 대각, 하
	static int[][] map; 
	static int N,cnt;
	
	public static boolean check(int x, int y) {
		
		if(map[x][y-1] ==0 && map[x-1][y] ==0)
			return true;
		return false;
	}
	
	public static void move(int x, int y, int dir) {
		if(x== N-1 && y == N-1) {
			cnt++;
			return;
		}
		int nx,ny;
		switch(dir) {
		case 0: //우
			nx = x+dx[dir];
			ny = y+dy[dir];
			if(nx < N && ny < N && map[nx][ny] == 0)
				move(nx,ny,dir);
			nx = x+dx[dir+1];	
			ny = y+dy[dir+1];
			if(nx < N && ny < N && map[nx][ny] == 0 && check(nx,ny))
				move(nx,ny,dir+1);
			break;
		case 1: //대각
			nx = x+dx[dir];
			ny = y+dy[dir];
			if(nx < N && ny < N && map[nx][ny] == 0 && check(nx,ny))
				move(nx,ny,dir);
			nx = x+dx[dir-1];	
			ny = y+dy[dir-1];
			if(nx < N && ny < N && map[nx][ny] == 0)
				move(nx,ny,dir-1);
			nx = x+dx[dir+1];	
			ny = y+dy[dir+1];
			if(nx < N && ny < N && map[nx][ny] == 0)
				move(nx,ny,dir+1);
			break;
		case 2: //하
			nx = x+dx[dir];
			ny = y+dy[dir];
			if(nx < N && ny < N && map[nx][ny] == 0)
				move(nx,ny,dir);
			nx = x+dx[dir-1];	
			ny = y+dy[dir-1];
			if(nx < N && ny < N && map[nx][ny] == 0 && check(nx,ny))
				move(nx,ny,dir-1);
			break;
		
		}
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		cnt=0;
		
		move(0,1,0);
		
		System.out.println(cnt);
		
		
		
	}

}
