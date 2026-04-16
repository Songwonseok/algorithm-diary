import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Ball{
	int x,y,dir;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Ball(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
}


public class Main{
	static int N, M,result;
	static boolean check = false;
	static Queue<Ball[]> que;
	static char[][] map;
	
	
	public static void game() {
		//게임시작
		//상하, 좌우 순서
		result=0;
		int size = que.size();
		while(!que.isEmpty()) {
			for(int i=0;i<size;i++) {
				Ball[] temp = que.poll();
				int dir = temp[0].dir;
				if(dir == 0) {
					upDown(0,temp[0],temp[1]);
					upDown(1,temp[0],temp[1]);
				}else {
					leftRight(0, temp[0], temp[1]);
					leftRight(1, temp[0], temp[1]);
				}
			}
			result++;
			if(result >10)
				return;
			if(check)
				return;
			size= que.size();
		}
		
	}
	// 위아래
	public static void upDown(int dir, Ball red, Ball blue) {
		int[] d = { -1, 1 };
		int rx = red.x;
		int bx = blue.x;
		boolean checkR=false, checkB=false;
		int cnt1=0;
		int cnt2=0;
		while (true) {
			if(map[rx+d[dir]][red.y] == 'O') {
				checkR=true;
				break;
			}
			if(map[rx+d[dir]][red.y] != '.') {
				break;
			}
			rx += d[dir];
			cnt1++;
		}
		while (true) {
			if (map[bx+d[dir]][blue.y] == 'O') {
				checkB=true;
				break;
			}

			if (map[bx+d[dir]][blue.y] != '.')
				break;
			bx += d[dir];
			cnt2++;
		}

		if (bx == rx && red.y == blue.y) {
			if (cnt1 > cnt2) {
				rx -= d[dir];
			} else
				bx -= d[dir];
		}
		
		if (checkR && !checkB) {
			check = true;
			return;
		}else if(checkB) {
			return;
		}
		if(rx==red.x && bx == blue.x)
			return;
		Ball[] temp = {new Ball(rx,red.y,1),new Ball(bx,blue.y,1)};
		que.add(temp);

		return;
	}
	// 양옆
	public static void leftRight(int dir, Ball red, Ball blue) {
		int[] d = { -1, 1 };
		int ry = red.y;
		int by = blue.y;
		boolean checkR=false, checkB=false;
		int cnt1=0;
		int cnt2=0;
		while (true) {
			if(map[red.x][ry+d[dir]] == 'O') {
				checkR=true;
				break;
			}
			if(map[red.x][ry+d[dir]] == '#' ) {
				break;
			}
			ry += d[dir];
			cnt1++;
		}
		while (true) {
			if (map[blue.x][by+d[dir]] == 'O') {
				checkB=true;
				break;
			}

			if (map[blue.x][by+d[dir]] == '#')
				break;
			by += d[dir];
			cnt2++;
		}
		if (by == ry && red.x == blue.x) {
			if (cnt1 > cnt2) {
				ry -= d[dir];
			} else
				by -= d[dir];
		}
		
		if (checkR && !checkB) {
			check = true;
			return;
		}else if(checkB) {
			return;
		}
		if(ry==red.y && by == blue.y)
			return;
		
		Ball[] temp = {new Ball(red.x,ry,0),new Ball(blue.x,by,0)};
		que.add(temp);
		return;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Ball red = null, blue=null, hall;
		que = new LinkedList<>();
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					red = new Ball(i, j);
					map[i][j] ='.';
				}
				else if (map[i][j] == 'B') {
					blue = new Ball(i, j);
					map[i][j] ='.';
				}
			}
		}
		que.add(new Ball[] {new Ball(red.x,red.y,0),new Ball(blue.x,blue.y,0)});
		que.add(new Ball[] {new Ball(red.x,red.y,1),new Ball(blue.x,blue.y,1)});
		
		game();
		if(check && result<=10)
			System.out.println(result);
		else
			System.out.println(-1);
		
	}
}
