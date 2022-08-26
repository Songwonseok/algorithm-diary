import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int KIM = Integer.parseInt(st.nextToken());
		int LIM = Integer.parseInt(st.nextToken());
		int count = 0;
		while(count < (N+1)/2) {
			count++;
			KIM = (KIM+1)/2;
			LIM = (LIM+1)/2;
			
			if(KIM == LIM) {
				System.out.println(count);
				return;
			}
		}
	}

}