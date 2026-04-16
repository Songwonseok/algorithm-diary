import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 1];
		int pay = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {

			if (i + T[i] <= N +1) { //일 가능
				dp[i] = P[i]; // 초기값
				int max = 0;
				for (int j = 1; j <= i; j++) { //앞에 계산한 값중 최대값 확인
					if (j + T[j] <= i && dp[j] > max)
						max = dp[j];
				}
				dp[i] += max; 
				
				if (dp[i] > pay) //원래 pay보다 크다면
					pay = dp[i];
			}
		}

		System.out.println(pay);

    }

}
