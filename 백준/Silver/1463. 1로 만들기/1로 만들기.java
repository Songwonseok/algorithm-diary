import java.io.*;
import java.util.*;

public class Main{
	static class Node{
		int num;
		int count;
		
		Node(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Node n = new Node(num,0);

		Queue<Node> que = new LinkedList<>();
		que.offer(n);
		int result= 0;
		
		while(!que.isEmpty()) {
			Node temp = que.poll();
			if(temp.num == 1) {
				result = temp.count;
				break;
			}
			
			if(temp.num %3 ==0) {
				que.offer(new Node(temp.num/3,temp.count+1));
			}
			if(temp.num %2 == 0) {
				que.offer(new Node(temp.num/2, temp.count+1));
			}
			if(temp.num >1) {
				que.offer(new Node(temp.num-1, temp.count+1));
			}
		}
		
		System.out.println(result);
	}

}
