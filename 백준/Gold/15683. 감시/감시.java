import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV{
	int x,y,dir,dirSize,num;
	public CCTV(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
		if(this.num == 2)
			dirSize =2;
		else
			dirSize =4;
	}
}

public class Main {
	static int N,M,min;
	static int[][] map,temp;
	static ArrayList<CCTV> list;
	
	public static void watchFive(int x, int y) {
		int[] dx= {-1,0,1,0}, dy= {0,1,0,-1};
		
		for(int dir=0;dir<4;dir++) {
			int nx = x;
			int ny = y;
			while(true) {
				nx+=dx[dir];
				ny+=dy[dir];
				if(nx<0 || nx >=N || ny <0 || ny>= M || map[nx][ny] ==6)
					break;
				map[nx][ny] =-1;
			}
		}
	}
	
	public static void dfs(int r) {
		if(min==0)
			return;
		
		if(r==list.size()) {
			for(int i=0;i<N;i++)
				temp[i] = map[i].clone();
			watch();
			return;
		}
		for(int i=0;i<list.get(r).dirSize;i++) {
			list.get(r).dir =i;
			dfs(r+1);
		}
	}
	
	
	public static void watch() {
		int cnt=0;
		int[] dx= {-1,0,1,0}, dy= {0,1,0,-1};
		for(int i=0;i<list.size();i++) {
			CCTV c = list.get(i);
			int nx = c.x;
			int ny = c.y;
			while(true) {
				nx+=dx[c.dir];
				ny+=dy[c.dir];
				
				if(nx<0 || nx >=N || ny <0 || ny>= M || temp[nx][ny] ==6)
					break;
				temp[nx][ny] =-1;
			}
			switch(c.num){
			case 1:
				break;
			case 2:
				nx = c.x;
				ny = c.y;
				while(true) {
					nx-=dx[c.dir];
					ny-=dy[c.dir];
					if(nx<0 || nx >=N || ny <0 || ny>= M || temp[nx][ny] ==6)
						break;
					temp[nx][ny] =-1;
				}
				break;
			case 3:
				nx = c.x;
				ny = c.y;
				while(true) {
					nx+=dx[(c.dir+1)%4];
					ny+=dy[(c.dir+1)%4];
					if(nx<0 || nx >=N || ny <0 || ny>= M || temp[nx][ny] ==6)
						break;
					temp[nx][ny] =-1;
				}
				break;
			case 4:
				nx = c.x;
				ny = c.y;
				while(true) {
					nx+=dx[(c.dir+1)%4];
					ny+=dy[(c.dir+1)%4];
					if(nx<0 || nx >=N || ny <0 || ny>= M || temp[nx][ny] ==6)
						break;
					temp[nx][ny] =-1;
				}
				nx = c.x;
				ny = c.y;
				while(true) {
					nx-=dx[(c.dir+1)%4];
					ny-=dy[(c.dir+1)%4];
					if(nx<0 || nx >=N || ny <0 || ny>= M || temp[nx][ny] ==6)
						break;
					temp[nx][ny] =-1;
				}
				break;
			}
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(temp[i][j]==0)
					cnt++;
		min = Math.min(min, cnt);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		min = 0;
		list = new ArrayList<>();
		ArrayList<Point> fives = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] !=0 && map[i][j] !=6) {
					if(map[i][j] == 5)
						fives.add(new Point(i,j));
					else	
						list.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		for(int i=0;i<fives.size();i++)
			watchFive(fives.get(i).x, fives.get(i).y);
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]==0)
					min++;
		dfs(0);
		System.out.println(min);
	}

}