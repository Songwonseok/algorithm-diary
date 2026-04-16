import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int K = Integer.parseInt(bf.readLine());
		HashSet<Integer> apples = new HashSet<>();
		StringTokenizer st = null;
		int[] dx= {0,1,0,-1}, dy= {1,0,-1,0}; //우 하 좌 상
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(bf.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y= Integer.parseInt(st.nextToken())-1;
			apples.add(x*N+y);
		}
		int L = Integer.parseInt(bf.readLine());
		int[][] move = new int[L][2];
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(bf.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D"))
				move[i][1]=1;
			else {
				move[i][1]=-1;
			}
		}
		
		int time=0;
		Queue<Integer> tale= new LinkedList<>();
		int dir=0;
		int index=0;
		boolean[][] snake= new boolean[N][N];
		tale.offer(0);
		int x=0;
		int y=0;
		snake[0][0]=true;
		while(true) {
			if(index < L && move[index][0] == time) {
				dir = (dir+move[index++][1])%4;
				if(dir<0)
					dir=3;
			}
			x += dx[dir];
			y += dy[dir];
			
			if(x<0 || x>=N || y<0 || y>=N || snake[x][y]) {
				time++;
				break;
			}
			snake[x][y] =true;
			tale.offer(x*N+y);
			if(!apples.contains(x*N+y)) {
				int t = tale.poll();
				snake[t/N][t%N] = false;
			}else {
				apples.remove(x*N+y);
			}
			time++;
		}
		
		System.out.println(time);
		
	}

}
