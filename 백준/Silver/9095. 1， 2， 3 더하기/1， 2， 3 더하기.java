import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			int result;
			if(n<=3)
				result = dp[n];
			
			for(int i=4;i<=n;i++) {
				dp[i] += dp[i-1] + dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
			
		}
	}

}
