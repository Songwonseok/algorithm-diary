import java.io.*;
import java.util.*;

class Shark{
	int r,c,speed,dir,size;

	public Shark(int r, int c, int speed, int dir, int size) {
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
	
}

public class Main {
	static int R,C;
	static ArrayList<Shark> list;
	static HashMap<Integer,Shark> map;
	static int[] dx= {-1,1,0,0}, dy= {0,0,1,-1};
	public static void move() {
		ArrayList<Shark> die = new ArrayList<>();
		//이동하고 맵에 저장
		for(int i=0;i<list.size();i++) {
			Shark s = list.get(i);
			int x = s.r;
			int y = s.c;
			for(int j = 0;j< s.speed;j++) {
				x+=dx[s.dir];
				y+=dy[s.dir];
				if(x<0 || x >=R || y<0 || y>=C) {
					x-=2*dx[s.dir];
					y-=2*dy[s.dir];
					if(s.dir == 0)
						s.dir=1;
					else if(s.dir ==1) {
						s.dir =0;
					}else if(s.dir==2)
						s.dir=3;
					else
						s.dir=2;
				}
			}
			s.r = x;
			s.c = y;
			if(!map.containsKey(s.r*C+s.c)) {
				map.put(s.r*C+s.c, s);
			}else {
				if(map.get(s.r*C+s.c).size > s.size)
					die.add(s);
				else {
					die.add(map.get(s.r*C+s.c));
					map.put(s.r*C+s.c, s);
				}
			}
		}
		//죽일놈 리스트에서 삭제
		for(int i=0;i<die.size();i++) {
			list.remove(die.get(i));
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new HashMap<>();
		int total=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			if(d <=1) {
				s = s%(2*R-2);
			}else {
				s = s%(2*C-2);
			}
			list.add(new Shark(r,c,s,d,z));
			map.put(r*C+c, list.get(i));
		}
		
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				if(map.containsKey(j*C+i)) {
					total += map.get(j*C+i).size;
					list.remove(map.get(j*C+i));
					break;
				}
			}
			map.clear();
			move();
		}
		
		System.out.println(total);
		
		
	}

}
