import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] DP = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = A[0];
		int answer = DP[0];
		
		for(int i=1;i<N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(A[j] < A[i] && DP[i] < DP[j] + A[i]) {
					DP[i] = DP[j] + A[i];
				}
			}
			if(DP[i] == 0) {
				DP[i] = A[i];
			}
			answer = Math.max(answer, DP[i]);
		}
		
		System.out.println(answer);
	}

}