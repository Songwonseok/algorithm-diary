import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static int getMaxValue(int[][] array) {
		int max = 0;
		for(int[] values : array) {
			int largerValue = Math.max(values[0], values[1]);
			max = Math.max(largerValue, max);
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n];
		int[][] DP = new int[n][2]; 
		for(int i=0;i<n;i++) {
			wines[i] = Integer.parseInt(br.readLine());
			if(i == 0) {
				Arrays.fill(DP[i], wines[i]);
			}else if(i==1) {
				DP[i][0] = wines[i];
				DP[i][1] = DP[i-1][0] + wines[i];
			}else if(i== 2) {
				DP[i][0] = DP[i-2][0] + wines[i];
				DP[i][1] = DP[i-1][0] + wines[i];
			}
		}
		for(int i=3;i<n;i++) {
			DP[i][1] = DP[i-1][0] + wines[i];
			DP[i][0] = Math.max(Math.max(DP[i-2][0], DP[i-2][1]), Math.max(DP[i-3][0],DP[i-3][1])) + wines[i];
		}
		
		int answer = getMaxValue(DP);
		System.out.println(answer);
	}
}