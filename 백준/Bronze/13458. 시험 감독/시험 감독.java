import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Long[] room = new Long[N];
		
		for(int i=0;i<N;i++)
			room[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		long R = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		for(int i=0;i<N;i++) {
			room[i] -= R;
		}
		long cnt=0L;
		for(int i=0;i<N;i++) {
			if(room[i] <=0) {
				if(room[i] == -R)
					continue;
				cnt++;
			}
			else {
				cnt += 1+ ((room[i]%C ==0)?(room[i]/C):(room[i]/C)+1);
			}
		}
		
		System.out.println(cnt);
	}

}
