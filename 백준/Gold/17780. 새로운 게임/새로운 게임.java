
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

class Chesspiece {
	int x, y, dir, num;
	Chesspiece up = null;
	Chesspiece down = null;

	public Chesspiece(int num, int x, int y, int dir) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Chesspiece findTop() {

		if (this.up == null)
			return this;
		return this.up.findTop();
	}

	public Chesspiece findBottom() {
		if (this.down == null)
			return this;
		return this.down.findBottom();
	}

	public int count() {
		int cnt = 1;
		Chesspiece p = this.findBottom();

		while (p.up != null) {
			p = p.up;
			cnt++;
		}
		return cnt;
	}

	public void moveAll(int nx, int ny) {
		Chesspiece p = this;
		p.x = nx;
		p.y = ny;
		while (p.up != null) {
			p = p.up;
			p.x = nx;
			p.y = ny;
		}

	}

	public void reverse() {
		Stack<Chesspiece> stack = new Stack<>();

		Chesspiece p = this;
		if (p.up == null)
			return;
		stack.push(p);
		while (p.up != null) {
			p = p.up;
			stack.push(p);
		}
		Chesspiece temp = null;
		Chesspiece pretemp = null;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			temp.down = pretemp;
			if (stack.isEmpty())
				temp.up = null;
			else
				temp.up = stack.peek();
			pretemp = temp;
		}
	}
}

public class Main {
	static int N, K;
	static int[][] map;
	static HashMap<Integer, Chesspiece> hash;
	static int[] di = { 0, 0, -1, 1 }, dj = { 1, -1, 0, 0 }; // 우좌상하

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		hash = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int num = 1; num <= K; num++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			hash.put(num, new Chesspiece(num, x - 1, y - 1, dir - 1));
		}
		int turn = 0;
		label: while (turn < 1000) {
			for (int num = 1; num <= K; num++) {
				if (hash.get(num).count() >= 4)
					break label;
			}
			move();
			turn++;
		}
		if (turn == 1000)
			System.out.println(-1);
		else
			System.out.println(turn);
	}

	public static void move() {

		for (int num = 1; num <= K; num++) {
			Chesspiece curr = hash.get(num);
			if(curr != curr.findBottom())
				continue;
			int nx = curr.x + di[curr.dir];
			int ny = curr.y + dj[curr.dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
				if (curr.dir == 0)
					curr.dir = 1;
				else if (curr.dir == 1)
					curr.dir = 0;
				else if (curr.dir == 2)
					curr.dir = 3;
				else
					curr.dir = 2;
				nx = curr.x + di[curr.dir];
				ny = curr.y + dj[curr.dir];
			}
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2)
				continue;

			if (map[nx][ny] == 1) {
				curr.moveAll(nx, ny);
				curr.reverse();
			} else {
				curr.moveAll(nx, ny);
			}

			for (int i = 1; i <= K; i++) {
				if (num != i && nx == hash.get(i).x && ny == hash.get(i).y
						&& curr.findBottom() != hash.get(i).findBottom()) {
					Chesspiece temp1 = curr.findBottom();
					Chesspiece temp2 = hash.get(i).findTop();
					hash.get(i).findTop().up = temp1;
					temp1.down = temp2;
					break;
				}
			}

		}
	}

}
