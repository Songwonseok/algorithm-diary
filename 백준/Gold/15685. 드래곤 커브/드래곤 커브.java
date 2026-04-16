import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] curv = new int[N][4];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			curv[i][0] =Integer.parseInt(st.nextToken());
			curv[i][1] =Integer.parseInt(st.nextToken());
			curv[i][2] =Integer.parseInt(st.nextToken());
			curv[i][3] =Integer.parseInt(st.nextToken());
		}
		map = new boolean[101][101];
		int[] dx = {0,-1,0,1}, dy= {1,0,-1,0};
		//curv
		
		for(int i=0;i<N;i++) {
			int x= curv[i][1];
			int y= curv[i][0];
			map[x][y] = true;
			int dir=curv[i][2];
			int k = curv[i][3];
			ArrayList<Integer> dirList = new ArrayList<>();
			dirList.add(dir);
			for(int j=1;j<=k;j++) {
				for(int d = dirList.size()-1;d>=0;d--) {
					dirList.add((dirList.get(d)+1)%4);
				}
			}
			for(int j=0;j<dirList.size();j++) {
				x +=dx[dirList.get(j)];
				y +=dy[dirList.get(j)];
				if(x>=0 && x<=100 && y>=0 && y<=100) {
					map[x][y] = true;
				}
			}
			
			
		}
		
		
		int total=0;
		//정사각형 확인
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(map[i][j]) {
					if(i+1 >=0 && i+1 <=100 && j+1 >=0 && j+1 <=100) {
						if(map[i][j+1] && map[i+1][j] && map[i+1][j+1])
							total++;
					}
				}
			}
		}
		
		
		System.out.println(total);
		
		
		
		
	}

}
