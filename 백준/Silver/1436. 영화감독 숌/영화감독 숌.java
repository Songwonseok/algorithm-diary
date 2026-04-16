import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cnt=0;
		int start=666;
		while(true) {
			if(Integer.toString(start).contains("666")) {
				cnt++;
			}
			if(cnt==N) {
				System.out.println(start);
				break;
			}
			start++;
		}
		
	}
}
