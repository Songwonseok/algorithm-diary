import java.math.*;
class Solution {
    static boolean[] prime;
    static boolean[] v, permCheck;
    static int result;
    static char[] selected,perm, number;
    
    static void permutation(int d, int end){
        if(d==end){
            if(perm.length == 0)
                return;
            
            StringBuilder str = new StringBuilder();
            for(int i=0;i<perm.length;i++)
                str.append(perm[i]);
            
            if(!prime[Integer.parseInt(str.toString())]) {
            	prime[Integer.parseInt(str.toString())] = true;
            	result++;
            }
            return;
        }
        
        for(int i=0;i<selected.length;i++){
            if(!permCheck[i]){
                permCheck[i] = true;
                perm[d] = selected[i];
                permutation(d+1,end);
                permCheck[i] = false;
            }
        }
    }
    
    static void BP(int depth){
        if(depth == number.length){
            int cnt=0;
            for(int i=0;i<depth;i++){
                if(v[i])
                    cnt++;
            }
            selected = new char[cnt];
            perm = new char[cnt];
            permCheck = new boolean[cnt];
            
            int index=0;
            for(int i=0;i<depth;i++){
                if(v[i])
                    selected[index++] = number[i];
            }
            
            permutation(0,cnt);
            
            return;
        }
        
        v[depth] = true;
        BP(depth+1);
        v[depth] = false;
        BP(depth+1);        
    }
    public int solution(String numbers) {
        int answer = 0;
        result =0;
        prime = new boolean[10000000];
        number = new char[numbers.length()];
        
        
        
        for(int i=0;i<number.length;i++)
            number[i] = numbers.charAt(i);
        
        v = new boolean[number.length];
        
        prime[0] = true;
        prime[1] = true;
        
        for(int i=2;i*i<10000000;i++){
        	if(!prime[i]) {
        		for(int j=i*i;j<10000000;j+=i){
        			prime[j] = true;
        		}
        	}
            
        }
        BP(0);
        answer = result;
        return answer;
    }
}