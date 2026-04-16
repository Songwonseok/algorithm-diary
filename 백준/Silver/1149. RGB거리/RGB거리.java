
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[][] value = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			value[i][0] = Integer.parseInt(st.nextToken());
			value[i][1] = Integer.parseInt(st.nextToken());
			value[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					value[i][j] = Math.min(value[i-1][1]+ value[i][j],value[i-1][2]+ value[i][j] );
				}else if(j==1) {
					value[i][j] = Math.min(value[i-1][0]+ value[i][j],value[i-1][2]+ value[i][j] );
				}else {
					value[i][j] = Math.min(value[i-1][0]+ value[i][j],value[i-1][1]+ value[i][j] );
				}
			}
		}
		int min = Math.min(value[N-1][0], value[N-1][1]);
		
		System.out.println(Math.min(min,value[N-1][2]));
	}

}
