import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,result;
	static ArrayList<Point> BBQ, house;
	static int[] index;
	static boolean[] v;
	static int[][] map;
	public static void comb(int start, int r) {
		if(r==M) {
			totalDistance();
			return;
		}
		for(int i=start;i<BBQ.size();i++) {
			if(!v[i]) {
				v[i] = true;
				index[r] = i;
				comb(i,r+1);
				v[i] = false;
			}
		}
		
		
		
	}
	public static void totalDistance() {
		int total=0;
		for(int i=0;i<house.size();i++) {
			int x= house.get(i).x;
			int y= house.get(i).y;
			int min=Integer.MAX_VALUE;
			for(int j=0;j<M;j++) {
				int cx = BBQ.get(index[j]).x;
				int cy = BBQ.get(index[j]).y;
				min= Math.min(min, Math.abs(x-cx)+Math.abs(y-cy));
			}
			total+=min;
		}

		
		result = Math.min(total, result);
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		BBQ = new ArrayList<>();
		house = new ArrayList<>();
		result = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==2)
					BBQ.add(new Point(i,j));
				else if(map[i][j] ==1)
					house.add(new Point(i,j));
			}
		}
		index= new int[M];
		v = new boolean[BBQ.size()];
		comb(0,0);
		System.out.println(result);
	}

}
