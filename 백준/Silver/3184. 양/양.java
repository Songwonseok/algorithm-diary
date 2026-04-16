import java.io.*;
import java.util.*;

public class Main{
	static char[][] pasture;
	static boolean[][] visit;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int sheep;
	static int wolf;
	static int N;
	static int M;
	
	public static void dfs(int x,int y) {
		visit[x][y] = true;
		if(pasture[x][y] == 'v')
			wolf++;
		else if(pasture[x][y] == 'o')
			sheep++;
		int nx;
		int ny;
		for(int i=0;i<4;i++) {
			nx = x+di[i];
			ny = y+dj[i];
		if(nx >=0 && nx <N && ny >= 0 && ny < M && !visit[nx][ny] && pasture[nx][ny] !='#' ) {
				dfs(nx,ny);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pasture = new char[N][M];
		visit = new boolean[N][M];
		ArrayList<int[]> w_index = new ArrayList<>();
		int totalSheep=0;
		
		for(int i=0;i<N;i++) {
			String line = bf.readLine();
			for(int j=0;j<M;j++) {
				pasture[i][j] = line.charAt(j);
				if(pasture[i][j] == 'v')
					w_index.add(new int[] {i,j});
				else if(pasture[i][j] == 'o')
					totalSheep++;
			}
		}
		int totalWolf=w_index.size();
		for(int i=0;i<w_index.size();i++) {
			sheep = 0;
			wolf=0;
			dfs(w_index.get(i)[0],w_index.get(i)[1]);
			if(sheep <= wolf)
				totalSheep -= sheep;
			else
				totalWolf -=wolf;
		}
		System.out.println(totalSheep+" "+totalWolf);	
		
	}

}
