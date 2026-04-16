import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] stencil;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		;
		stencil = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= M; j++)
				stencil[i][j] = Integer.parseInt(st.nextToken());
			
		}
		
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotation(x, d, k);
		}
		System.out.println(sum(stencil));

	}

	
	public static int sum(int[][] t) {
		int sum=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(t[i][j] != -1) {
					sum+= t[i][j];
				}
			}
		}
		
		return sum;
	}
	
	private static void rotation(int x, int d, int k) {
		int[] dir = { 1, -1 };
		int[][] temp = new int[N + 1][];
		for (int t = 1; t <= N; t++)
			temp[t] = stencil[t].clone();

		// 회전
		for (int i = 1; i <= N; i++) {
			if (i % x == 0) {
				for (int j = 1; j <= M; j++) {
					int next = j + dir[d] * k;
					if (next > M) {
						next = next - M;
					} else if (next < 1) {
						next = M + next;
					}
					temp[i][next] = stencil[i][j];
				}

			}
		}
		
		
		// 삭제
		ArrayList<int[]> delete = new ArrayList<>();
		int[][] de = { { 0, 1 }, { 0, -1 }, { 1, 0 } };
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (temp[i][j] != -1) {
					for (int a = 0; a < 3; a++) {
						int ni = i + de[a][0];
						int nj = j + de[a][1];

						if (ni > N || ni < 1)
							break;
						if (nj < 1)
							nj = M;
						else if (nj > M)
							nj = 1;

						if (temp[i][j] == temp[ni][nj]) {
							if (!delete.contains(new int[] { ni, nj }))
								delete.add(new int[] { ni, nj });
							if (!delete.contains(new int[] { i, j }))
								delete.add(new int[] { i, j });
						}
					}
				}
			}
		}
		
		for (int i = 0; i < delete.size(); i++) {
			temp[delete.get(i)[0]][delete.get(i)[1]] = -1;
		}
		if(delete.size() == 0) {
			// 증감처리
			int cnt =0;
			double avg = 0;
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					if(temp[i][j] != -1) {
						cnt++;
					}
				}
			}
			avg =(double)sum(temp)/cnt;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					if(temp[i][j] != -1) {
						if(temp[i][j] > avg)
							temp[i][j]--;
						else if(temp[i][j] < avg)
							temp[i][j]++;
					}
				}
			}
			
		}
		for(int i=1;i<=N;i++)
			stencil[i] = temp[i].clone();
	}

}