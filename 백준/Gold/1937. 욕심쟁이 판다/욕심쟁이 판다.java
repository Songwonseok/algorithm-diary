import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, memo;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static int N, max;
	
	public static int dfs(int x,int y) {
		if(memo[x][y]!=0) return memo[x][y];
		memo[x][y] =1;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny <N && map[nx][ny] > map[x][y]) {
				memo[x][y] = Math.max(memo[x][y], dfs(nx,ny)+1);
			}
		}
		return memo[x][y];
	}
	
//	public static void dfs(int x,int y, int cnt) {
//		max =Math.max(max, cnt);
//		for(int i=0;i<4;i++) {
//			int nx = x+dx[i];
//			int ny = y+dy[i];
//			if(nx>=0 && nx <N && ny >=0 && ny <N && map[nx][ny] > map[x][y] && memo[nx][ny] < cnt+1) {
//				memo[nx][ny] = cnt+1;
//				dfs(nx,ny,cnt+1);
//			}
//		}
//	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
					
					max = Math.max(max,dfs(i,j));
			}
		}
		
		System.out.println(max);
		
	}

}