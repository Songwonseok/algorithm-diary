class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int currTime = 0;
        int hp = health;
        
        for(int[] attack : attacks) {
            int diff = attack[0] - currTime - 1;
            
            currTime = attack[0];
            
            hp += diff * bandage[1];
            
            if(diff >= bandage[0]) {
                hp += (diff / bandage[0]) * bandage[2];
            }
            
            if(hp > health) {
                hp = health;
            }
            
            hp -= attack[1];
            
            if(hp <= 0) {
                return -1;
            }
            
        }
        
        
        return hp;
    }
}