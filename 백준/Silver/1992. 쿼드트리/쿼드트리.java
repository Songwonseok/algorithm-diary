
import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	public static void qt(int si,int sj, int ei, int ej) {
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		char k = map[si][sj];
		for(int i=si;i<=ei;i++) {
			for(int j=sj;j<=ej;j++) {
				if(map[i][j] != k) {
					System.out.print("(");
						qt(si,sj,mi,mj);
						qt(si,mj+1,mi,ej);
						qt(mi+1,sj,ei,mj);
						qt(mi+1,mj+1,ei,ej);
						System.out.print(")");
					return;
				}
			}
		}
		System.out.print(k);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			map[i] = bf.readLine().toCharArray();
		}
		
		qt(0,0,N-1,N-1);

		
		
		
	}
}
