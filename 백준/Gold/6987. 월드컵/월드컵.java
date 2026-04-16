

import java.util.*;
import java.io.*;

public class Main {
	static int[] gama;
	static int[] gamb;
	static int[] winn;
	static int[] lose;
	static int[] draw;
	static int n;
	static int a[] = { 0, 1, 2, 3, 4, 5};
	static boolean v[];
	static int temp[];

	public static void comb(int start, int r) {
		if (r == 2) {
		//System.out.println(n+" "+temp[0]+" "+temp[1]);
			gama[n] = temp[0];
			gamb[n++] = temp[1];
			return;
		}
		for (int i = start; i < 6; i++) {
			if (!v[i]) {
				v[i] = true;
				temp[r] = a[i];
				comb(i, r + 1);
				v[i] = false;
			}
		}

	}

	public static int dfs(int n) {
		if (n >= 15) {
			int total =0;
			for(int i=0;i<6;i++) {
				total += winn[i]+draw[i]+lose[i];
			}
			if(total == 0)
				return 1;
			else
				return 0;
		}
		int a = gama[n];
		int b = gamb[n];

		if (winn[a] != 0 && lose[b] != 0) { // a가 이기고 b가 지는 경우
			winn[a]--;
			lose[b]--;
			if ((dfs(n + 1) == 1))
				return 1;
			winn[a]++;
			lose[b]++;
		}
		if (draw[a] != 0 && draw[b] != 0) { // a,b가 비기는 경우
			draw[a]--;
			draw[b]--;
			if (dfs(n + 1) == 1)
				return 1;
			draw[a]++;
			draw[b]++;
		}
		if (lose[a] != 0 && winn[b] != 0) { // a가 지고 b가 이기는 경우
			lose[a]--;
			winn[b]--;
			if ((dfs(n + 1) == 1))
				return 1;
			lose[a]++;
			winn[b]++;

		}
		return 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			winn = new int[6];
			draw = new int[6];
			lose = new int[6];
			temp = new int[2];
			gama = new int[15];
			gamb = new int[15];
			v = new boolean[6];
			n = 0;
			for (int j = 0; j < 6; j++) {
				winn[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			System.out.print(dfs(0)+" ");
			
		}
	}
}
