import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(bf.readLine());
    	int[] DP = new int[N+1];
    	int T,P;
    	for(int i=0;i<N;i++) {
    		StringTokenizer st = new StringTokenizer(bf.readLine());
    		T = Integer.parseInt(st.nextToken());
    		P = Integer.parseInt(st.nextToken());
    		DP[i+1] = Math.max(DP[i+1], DP[i]);
    		if(i+T > N)
    			continue;
    		DP[i+T] = Math.max(DP[i+T], DP[i]+P);
    	}
    	
    	System.out.println(DP[N]);
    	

    }

}
