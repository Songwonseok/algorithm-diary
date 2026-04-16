
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String N = bf.readLine();
		
		int size = 9*N.length();
		boolean flag= false;
		int answer =Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int M = Integer.parseInt(N);
		String num = new String();
		int result=0;
		for(int i=M-size;i<=M;i++) {
			num = Integer.toString(i);
			result = Integer.parseInt(num);
			for(int j=0;j<num.length();j++) {
				result += num.charAt(j)-'0';
			}
			if(result == M) {
				flag = true;
				answer = i;
				if(min > answer)
					min = answer;
			}
		}
		if(flag)
			System.out.println(min);
		else
			System.out.println(0);
		
	}

}
