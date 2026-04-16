import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,-1,1};
		
			Queue<int[]> que = new LinkedList<>();
			int N=sc.nextInt();
			int M= sc.nextInt();
			int[][] map = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			String line = "";
			for(int i=0;i<N;i++) {
				line = sc.next();
				for(int j=0;j<M;j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			int result=1;
			que.offer(new int[] {0,0});
			int size = que.size();
			int cnt=0;
			map[0][0] = 0;
			
			while(!que.isEmpty()) {
				int[] curr = que.poll();
				cnt++;
				map[curr[0]][curr[1]] = 0;
				if(curr[0] == N-1 && curr[1] == M-1)
					break;
				for(int i=0;i<4;i++) {
					int ni = curr[0]+di[i];
					int nj = curr[1]+dj[i];
					if(ni >=0 && ni <N && nj >=0 && nj < M && map[ni][nj] == 1) {
						que.offer(new int[] {ni,nj});
						map[ni][nj] = 0;
					}
					
				}
				if(size == cnt) {
					result++;
					cnt = 0;
					size = que.size();
				}
				
			}
			
			System.out.println(result);
		
	}

}
