import java.util.*;

class Solution {
    boolean[] isSelected, isPrimes;
    HashSet<Integer> set;
    int answer;
    String numbers;
    
    public int solution(String numbers) {
        answer = 0;
        
        isPrimes = getIsPrimes();
        this.numbers = numbers;
        isSelected = new boolean[numbers.length()];
        set = new HashSet();
        bruteForce(0);
        
        return answer;
    }
    
    public void perm(int depth, int permLength, char[] acc) {
        if(depth == permLength) {
            int value = Integer.parseInt(new String(acc));
            
            if(set.contains(value)) {
                return;
            }
            
            set.add(value);
            
            if(isPrimes[value]) {
                answer++;
            }
            
            return;
        }
        
        for(int i = 0; i < isSelected.length; i++) {
            if(isSelected[i]) {
                if(depth == 0 && numbers.charAt(i) == '0') {
                    continue;
                }
                
                isSelected[i] = false;
                acc[depth] = numbers.charAt(i);
                perm(depth+1, permLength, acc);
                isSelected[i] = true;
            }
        }
        
    }
    
    public void bruteForce(int depth) {
        if(depth == isSelected.length) {
            int permLength = 0;
            
            for(int i = 0; i < isSelected.length; i++) {
                if(isSelected[i]) {
                    permLength++;
                }
            }
            
            if(permLength == 0) {
                return;
            }
            
            char[] acc = new char[permLength];
            
            perm(0, permLength, acc);
            return;
        }
        bruteForce(depth + 1);
        isSelected[depth] = true;
        bruteForce(depth + 1);
        isSelected[depth] = false;
        
    }
    
    public boolean[] getIsPrimes() {
        int MAX_SIZE = 10000000;
        boolean[] isPrimes = new boolean[MAX_SIZE]; // 최대 7자리까지 가능
        
        Arrays.fill(isPrimes , true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        
        for(int i = 2; i * i < MAX_SIZE; i++) {
            if(isPrimes[i]) {
                for(int j = i * 2; j < MAX_SIZE; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        
        return isPrimes;
        
    }
}