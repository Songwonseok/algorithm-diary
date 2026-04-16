import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map,v;
	static boolean flag;
	static int N, M, H, result;
	static int[] index;

	public static void solve(int r,int si,int sj, int size) {
		if(flag)
			return;
		if (r == size) {
			for(int i=0;i<size;i++) {
				int x= index[i]/N;
				int y= index[i]%N;
				map[x][y] = true;
			}
			move();
			for(int i=0;i<size;i++) {
				int x= index[i]/N;
				int y= index[i]%N;
				map[x][y] = false;
			}
			return;
		}
		
		for(int i=si;i<H;i++) {
			for(int j=sj;j<N-1;j++) {
				if((j-1 >=0 && !map[i][j-1])|| j==0) {
					if((j+1 < N && !map[i][j]) || j==N-1 ) {
						if(!v[i][j]) {
							v[i][j]= true;
							index[r]= i*N+j;
							solve(r+1,i,j,size);
							v[i][j]=false;
						}
					}
				}
			}
			sj=0;
		}
	}

	public static void move() {
		boolean check = true;
		for(int i=0;i<N;i++) {
			int x = 0;
			int y = i;
			while(x<H) {
				if(y-1 >=0 && map[x][y-1]) {
					y--;
				}else if(y+1 <N && map[x][y]) {
					y++;
				}
				x++;
			}
			if(y!=i) {
				check=false;
				break;
			}
		}
		if(check)
			flag = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		result = -1;
		map = new boolean[H][N];
		flag = false;
		v = new boolean[H][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = true;
		}
		move();
		if (flag)
			result = 0;
		else {
			for (int r = 1; r <= 3; r++) {
				index = new int[r];
				solve(0,0,0,r);
				if(flag) {
					result=r;
					break;
				}
			}
		}
		System.out.println(result);
	}

}