import java.io.*;
import java.util.*;

public class Main{
	public static int[] perm, number = {0,1,2,4,5,6,7,8};
	public static int[][] result;
	public static int N, max;
	public static HashMap<Integer,Integer> map;
	public static void swap(int i, int j) {
		if(i==j) return;
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
	
	public static void perm(int r) {
		if(r==8) {
			map = new HashMap<>();
			map.put(3, 0);
			for(int i=0;i<8;i++) {
				map.put(number[i], i+1);
			}
			game();
			return;
		}
		
		for(int i=r;i<8;i++) {
			swap(r,i);
			perm(r+1);
			swap(r,i);
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		result = new int[N][9];
		perm = new int[8];
		max=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		// 타순 정하기

		System.out.println(max);
	}

	public static void game() {
		int start = 0;
		int score = 0;
		for (int i = 0; i < N; i++) {

			int[] ru = new int[4];
			int out = 0;
			while (out < 3) {
				ru[0] = 1;
				int c = result[i][map.get(start)];
				switch (c) {
				case 0:// 아웃
					out++;
					break;
				case 1:// 안타
					for (int  n = 3; n >= 0; n--) {
						if (ru[n] != 0) {
							if (n == 4 - c) {
								score++;
								ru[n] = 0;
							} else {
								ru[n + 1] = 1;
								ru[n] = 0;
							}
						}
					}
					break;
				case 2:// 2
					for (int  n = 3; n >= 0; n--) {
						if (ru[n] != 0) {
							if (n >= 4 - c) {
								score++;
								ru[n] = 0;
							} else {
								ru[n + 2] = 1;
								ru[n] = 0;
							}
						}
					}
					break;
				case 3:// 3
					for (int n = 3; n >= 0; n--) {
						if (ru[n] != 0) {
							if (n >= 4 - c) {
								score++;
								ru[n] = 0;
							} else {
								ru[n + 3] = 1;
								ru[n] = 0;
							}
						}
					}
					break;
				default:// 홈런
					for (int   n = 3; n >= 0; n--) {
						if (ru[n] != 0) {
							score++;
							ru[n] = 0;
						}
					}
				}
				start++;
				if (start == 9)
					start = 0;
			}
		}
		max = Math.max(max, score);

	}

}
