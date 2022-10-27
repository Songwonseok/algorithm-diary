class Solution {
    public int solution(int[][] dots) {
        
        if(getInclination(dots[0], dots[1]) == getInclination(dots[2], dots[3])) {
            return 1;
        }else if(getInclination(dots[0], dots[2]) == getInclination(dots[1], dots[3])) {
            return 1;
        }else if(getInclination(dots[0], dots[3]) == getInclination(dots[1], dots[2])) {
            return 1;
        }
        
        return 0;
    }
    
    // 기울기 구하는 공식 (y2 - y1)/ (x2 - x1) 
    public double getInclination(int[] dot1, int[] dot2) {
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}