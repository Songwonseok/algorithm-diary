import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int air; // air: 아래쪽 부분, air-1 : 위쪽 부분
	
	
	public static int time() {
		int sum=0;
		ArrayList<int[]> dust = new ArrayList<>();
		
		for(int i=0;i<T;i++) {
			dust = dustCheck();
			spread(dust);
			
			upRota();
			
			downRota();
		}
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum += map [i][j];
			}
		}
		return sum+2; // 공기청정기 제외
	}
	
	private static ArrayList<int[]> dustCheck() {
		ArrayList<int[]> check = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					check.add(new int[] {i,j, map[i][j]});
				}
			}
		}
		return check;
	}

	private static void spread(ArrayList<int[]> dust) {
		int x;
		int y;
		int[] di = {0,-1,0,1}; // 우 상 좌 하
		int[] dj = {1,0,-1,0};
		int sum;
		for(int i=0;i<dust.size();i++) {
			x= dust.get(i)[0];
			y= dust.get(i)[1];
			sum=0;
			for(int j=0;j<4;j++) {
				if(x+di[j] >=0 && x+di[j] < R && y+dj[j] >=0 && y+dj[j] <C && map[x+di[j]][y+dj[j]] != -1) {
					map[x+di[j]][y+dj[j]] += dust.get(i)[2]/5;
					sum += dust.get(i)[2]/5;
				}
			}
			map[x][y] -= sum;
		}
	}
	
	private static void upRota() {
		Queue<Integer> que = new LinkedList<>();
		int[] di = {0,-1,0,1};
		int[] dj = {1,0,-1,0};
		int x= air-1;
		int y= 1;
		que.offer(map[x][y]);
		for(int i=0;i<4;i++) {
			while(x+di[i] >=0 && x+di[i] < air && y+dj[i] >=0 && y+dj[i] <C) {
				
				x += di[i];
				y += dj[i];
				if(x == air-1 && y == 0)
					break;
				que.offer(map[x][y]);
				
			}
		}
		y= 1;
		map[x][y] =0;
		for(int i=0;i<4;i++) {
			while(x+di[i] >=0 && x+di[i] < air && y+dj[i] >=0 && y+dj[i] <C) {
				x += di[i];
				y += dj[i];
				if(x == air-1 && y == 0)
					break;
				map[x][y] = que.poll();
			}
		}
	}

	private static void downRota() {
		Queue<Integer> que = new LinkedList<>();
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		int x= air;
		int y= 1;
		que.offer(map[x][y]);
		for(int i=0;i<4;i++) {
			while(x+di[i] >=air && x+di[i] < R && y+dj[i] >=0 && y+dj[i] <C) {
				x += di[i];
				y += dj[i];
				if(x == air && y == 0)
					break;
				que.offer(map[x][y]);
				
			}
		}
		y= 1;
		map[x][y] =0;
		for(int i=0;i<4;i++) {
			while(x+di[i] >=air && x+di[i] < R && y+dj[i] >=0 && y+dj[i] <C) {
				x += di[i];
				y += dj[i];
				if(x == air && y == 0)
					break;
				map[x][y] = que.poll();
			}
		}
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			st = new StringTokenizer(bf.readLine()," ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(bf.readLine()," ");
				for(int j=0;j<C;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == -1)
						air = i;
				}
			}
			System.out.println(time());
	}

}
