import java.io.*;
import java.util.*;

public class Main {
	static int N, max, cnt;

	public static int[][] move(int[][] map, int dir) {
		int[][] temp = new int[N][N];
		boolean[][] v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = map[i].clone();
		}
		int count=0;
		switch (dir) {
		case 0: // 상
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] != 0) {
						int bi = i;
						int ai = i - 1;
						while (ai >= 0) {
							if (temp[ai][j] != 0 && !v[ai][j]) {
								if (temp[ai][j] == temp[bi][j]) {
									temp[ai][j] *= 2;
									max = Math.max(max, temp[ai][j]);
									v[ai][j] = true;
									temp[bi][j] = 0;
									count++;
									break;
								} else 
									break;
							} else if(!v[ai][j] && temp[ai][j] == 0){
								temp[ai][j] = temp[bi][j];
								temp[bi][j] = 0;
								bi = ai;
								ai--;
								count++;
							}else
								break;
						}
					}
				}
			}
			break;
		case 1: // 하
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] != 0) {
						int bi = i;
						int ai = i + 1;
						while (ai < N) {
							if (temp[ai][j] != 0 && !v[ai][j]) {
								if (temp[ai][j] == temp[bi][j]) {
									temp[ai][j] *= 2;
									max = Math.max(max, temp[ai][j]);
									v[ai][j] = true;
									temp[bi][j] = 0;
									count++;
									break;
								} else 
									break;
							} else if(!v[ai][j] && temp[ai][j] == 0) {
								temp[ai][j] = temp[bi][j];
								temp[bi][j] = 0;
								bi = ai;
								ai++;
								count++;
							}else
								break;
						}
					}
				}
			}
			break;
		case 2: // 좌
			for (int j = 1; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (temp[i][j] != 0) {
						int bj = j;
						int aj = j - 1;
						while (aj >= 0) {
							if (temp[i][aj] != 0 && !v[i][aj]) {
								if (temp[i][aj] == temp[i][bj]) {
									temp[i][aj] *= 2;
									max = Math.max(max, temp[i][aj]);
									v[i][aj] = true;
									temp[i][bj] = 0;
									count++;
									break;
								} else 
									break;
							} else if(!v[i][aj] && temp[i][aj] == 0) {
								temp[i][aj] = temp[i][bj];
								temp[i][bj] = 0;
								bj = aj;
								aj--;
								count++;
							}else
								break;
						}
					}
				}
			}
			break;
		case 3: // 우
			for (int j = N - 2; j >= 0; j--) {
				for (int i = 0; i < N; i++) {
					if (temp[i][j] != 0) {
						int bj = j;
						int aj = j + 1;
						while (aj < N) {
							if (temp[i][aj] != 0 && !v[i][aj]) {
								if (temp[i][aj] == temp[i][bj]) {
									temp[i][aj] *= 2;
									max = Math.max(max, temp[i][aj]);
									v[i][aj] = true;
									temp[i][bj] = 0;
									count++;
									break;
								}else
									break;
							} else if(!v[i][aj] && temp[i][aj] == 0){
								temp[i][aj] = temp[i][bj];
								temp[i][bj] = 0;
								bj = aj;
								aj++;
								count++;
							}else
								break;
						}
					}
				}
			}
			break;
		}
		if(count !=0)
			return temp;
		else
			return null;
	}

	public static void game(int[][] board) {
		Queue<int[][]> que = new LinkedList<>();
		que.add(board);
		int size = que.size();
		while (cnt < 5) {
			for (int i = 0; i < size; i++) {
				int[][] map = que.poll();
				for(int j=0;j<4;j++) {
					int[][] temp = move(map,j);
					if(temp == null)
						continue;
					que.add(temp);
				}
			}
			cnt++;
			size = que.size();
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[][] board = new int[N][N];
		max = 0;
		cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
			}
		}
		game(board);
		System.out.println(max);

	}

}
