import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	static int N, operNum;
	static long max;
	static char[] line;
	static int[] v;

		public static long operation(long num1, long num2, char oper) {
			long result = 0;
			switch (oper) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			}
			return result;
		}

		public static void powerSet(int r) {
			if (r == operNum) {
				char[] temp = line.clone();
				ArrayList<Long> list = new ArrayList<>();
				int start=temp[0]-'0';
				for (int i = 0; i < operNum; i++) {
					if (v[i] == 1) {
						list.add(operation(Long.valueOf(temp[i * 2]+""), Long.valueOf(temp[i * 2 + 2]+""), temp[i * 2 + 1]));
						temp[i * 2 + 1] = '.';
						temp[i * 2] = '.';
						temp[i * 2 + 2] = '.';
					}
				}
				int index = 0;
				long result =0; 
				boolean flag=(temp[0] == '.') ?true:false;
				
				if(flag)
					result = list.get(index++);
				else
					result=Long.valueOf(temp[0]+"");
				
				
				int cnt=(!flag)?1:3;
				
				while(cnt<temp.length) {
					if(temp[cnt+1] != '.') {
						result = operation(result, Long.valueOf(temp[cnt+1]+""),temp[cnt]);
						cnt+=2;
						continue;
					}else {
						result = operation(result,
								list.get(index++),
								temp[cnt]);
						cnt+=4;
					}
				}
				max=Math.max(max, result);
				return;
			}
			if(r==0) {
				v[r]=0;
				powerSet(r + 1);
				v[r]=1;
				powerSet(r + 1);
			}else {
				if(v[r-1] ==0) {
					v[r] = 0;
					powerSet(r + 1);
					v[r] = 1;
					powerSet(r + 1);
				}else {
					v[r]=0;
					powerSet(r + 1);
				}
			}
		}

		public static void main(String[] args) throws Exception {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(bf.readLine());
			operNum = N / 2;
			max= Long.MIN_VALUE;
			line = bf.readLine().toCharArray();
			v = new int[operNum];
			powerSet(0);
			System.out.println(max);
			

		}

	}
