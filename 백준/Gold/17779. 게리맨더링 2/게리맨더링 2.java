import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, result;
	static int[][] a,map; // 경계선 좌표
	static int[] di = { 1, 1, -1, -1 }, dj = { -1, 1, 1, -1 }; // 대각선 방향
	
	public static void sum() {
		int[] sums = new int[5];
		boolean[][] visit = new boolean[N][N];
		int max=0;
		int min = Integer.MAX_VALUE;
		//1번구역
		int end=a[3][1];
		for(int i=0;i<a[0][0];i++) {
			if(i>=a[3][0])
				end--;
			for(int j=0;j<=end;j++) {
				sums[0] += map[i][j];
				visit[i][j] = true;
			}
		}
		//2번구역
		int start=a[3][1]+1;
		for(int i=0;i<=a[2][0];i++) {
			for(int j=start;j<N;j++) {
				sums[1] += map[i][j];
				visit[i][j] = true;
			}
			if(i>=a[3][0])
				start++;
		}
		
		//3번구역
		int dis = a[0][1]-1;
		for(int i=a[0][0];i<N;i++) {
			for(int j=0;j<=dis;j++) {
				sums[2] += map[i][j];
				visit[i][j] = true;
			}
			if(i<a[1][0])
				dis++;
		}
		//4번구역
		start = a[2][1];
		for(int i=a[2][0]+1;i<N;i++) {
			for(int j=start;j<N;j++) {
				sums[3] += map[i][j];
				visit[i][j] = true;
			}
			if(start>a[1][1])
				start--;
		}
		//5번구역
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j])
					sums[4] += map[i][j];
			}
		}
		for(int i=0;i<5;i++) {
			max= Math.max(max, sums[i]);
			min = Math.min(min, sums[i]);
		}
		
		result = Math.min(result, max-min);
		
		
		
	}
	
	
	public static void dfs(int x, int y, int sx, int sy, int left, int right, int dir) {
		if (x == sx && y == sy && dir == 3) {
			a[dir][0] =x;
			a[dir][1] =y;
			sum();
			return;
		}
		if (dir == 0) {
			int nx = x + di[dir];
			int ny = y + dj[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				dfs(nx, ny, sx, sy, left + 1, right, dir);
			}
			nx = x + di[dir + 1];
			ny = y + dj[dir + 1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && left != 0) {
				a[dir][0] = x;
				a[dir][1] = y;
				dfs(nx, ny, sx, sy, left, right + 1, dir + 1);
			}
		} else if (dir == 1) {
			int nx = x + di[dir];
			int ny = y + dj[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				dfs(nx, ny, sx, sy, left, right + 1, dir);
			}
			nx = x + di[dir + 1];
			ny = y + dj[dir + 1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && right != 0) {
				a[dir][0] = x;
				a[dir][1] = y;
				dfs(nx, ny, sx, sy, left - 1, right, dir + 1);
			}
		} else if (dir == 2) {
			int nx = x + di[dir];
			int ny = y + dj[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && left != 0) {
				dfs(nx, ny, sx, sy, left - 1, right, dir);
			}
			nx = x + di[dir + 1];
			ny = y + dj[dir + 1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && left==0) {
				a[dir][0] = x;
				a[dir][1] = y;
				dfs(nx, ny, sx, sy, left, right - 1, dir + 1);
			}
		} else {
			int nx = x + di[dir];
			int ny = y + dj[dir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && right != 0) {
				dfs(nx, ny, sx, sy, left, right-1, dir);
			}
		}
//			[3, 1] [4, 2] [1, 5] [0, 4] 
//					39 0 10 19 25 		
//			[3, 1] [4, 2] [2, 4] [1, 3] 
//					26 5 10 19 33 
		
//		[1, 0] [2, 1] [1, 2] [0, 1] 
//				0 19 0 56 18 
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		result=Integer.MAX_VALUE;
		N= Integer.parseInt(bf.readLine());
		map = new int[N][N];
		a = new int[4][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=1;j<N-1;j++) {
				dfs(i,j,i,j,0,0,0);
			}
		}
		
		System.out.println(result);
		
		
	}

}
