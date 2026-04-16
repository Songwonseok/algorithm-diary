import java.io.*;
import java.util.StringTokenizer;



public class Main {
	static int N, max;
	static int[] attack;
	public static void solve(int r, int[] temp) {
		if(max == N)
			return;
		if(r== N) {
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(temp[i]<=0)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		if(temp[r]<= 0 )
			solve(r+1,temp);
		else {
			boolean flag = false;
			for(int i=0;i<N;i++) {
				if(i == r)
					continue;
				if(temp[i] <= 0)
					continue;
				else {
					int[] temp2 = temp.clone();
					temp2[i] -= attack[r];
					temp2[r] -= attack[i];
					solve(r+1,temp2);
					flag = true;
				}
			}
			if(!flag)
				solve(r+1,temp);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[] life = new int[N];
		attack = new int[N];
		StringTokenizer st= null;
		max=0;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(bf.readLine());
			life[i] = Integer.parseInt(st.nextToken());
			attack[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,life);
		System.out.println(max);
		
		
		
	}

}
