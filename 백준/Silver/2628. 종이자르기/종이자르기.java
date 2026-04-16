
import java.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] ar = new char[N][M];
		int K = sc.nextInt();
		ArrayList<Integer> garo = new ArrayList<>(); //가로 분할선 저장
		ArrayList<Integer> sero = new ArrayList<>(); //세로 분할선 저장
		int max=0;
		
		for(int i=0;i<K;i++) {
			int num = sc.nextInt();
			if(num == 0)
				garo.add(sc.nextInt());
			else
				sero.add(sc.nextInt());
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		int[] ga = new int[garo.size()+1]; //가로 분할선 사이 간격
		int[] se = new int[sero.size()+1]; //세로 분할선 사이 간격
		
		
		
		if(garo.size() != 0) {
			ga[0] = garo.get(0);
			ga[ga.length-1] = M-garo.get(garo.size()-1); // 가장 마지막 분할선부터 끝까지
		}
		else
			ga[0] = M; //분할선이 없으면 전체 M
		
		if(sero.size() != 0) {
			se[0] = sero.get(0);
			se[se.length-1] = N-sero.get(sero.size()-1); //가장 마지막 분할선부터 끝까지
		}
		else
			se[0] = N; //분할선이 없으면 전체 N
		
		for(int i=1;i<garo.size();i++) {
			 ga[i] = garo.get(i)- garo.get(i-1); //분할선 간격 구하기
		}
		
		for(int i=1;i<sero.size();i++) {
			se[i] = sero.get(i)- sero.get(i-1); //분할선 간격 구하기
		}
		
		
		
		for(int i=0;i<ga.length;i++) {
			for(int j=0;j<se.length;j++) {
				if(ga[i]*se[j] > max)
					max = ga[i]*se[j]; // 나눠진 부분들중 최대값을 구함
			}
		}
		
		System.out.println(max);
		
		
	}

}
