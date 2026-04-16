import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Stack<int[]> stack = new Stack<>();
		Queue<int[]> queue = new LinkedList<>();
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int N = sc.nextInt();
		boolean[][] visit = new boolean[N][N];
		int[][] ar= new int[N][N];
		char[][] ch = new char[N][N];
		int[] curr = new int[2];
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String line = sc.next();
			ch[i] = line.toCharArray();
			for(int j=0;j<N;j++) {
				ar[i][j] = ch[i][j]-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt =0;
				if(ar[i][j] == 1 && visit[i][j] == false) {
					visit[i][j] =true;
					queue.offer(new int[]{i,j});
					while(!queue.isEmpty()) {
						curr = queue.poll();
						cnt++;
						for(int k=0;k<4;k++) {
							int ni = curr[0]+di[k];
							int nj = curr[1]+dj[k];
							boolean flag = (ni <N && ni>=0 && nj <N && nj >=0 );
							if(flag &&ar[ni][nj] ==1 &&visit[ni][nj] == false) {
								visit[ni][nj] = true;
								queue.offer(new int[] {ni,nj});
							}
						}
					}
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		int size = result.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
			System.out.println(result.get(i));
		
		
		
	}

}
