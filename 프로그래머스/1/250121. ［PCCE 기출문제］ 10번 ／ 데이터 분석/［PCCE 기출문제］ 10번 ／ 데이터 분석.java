import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int filterIndex = getIndex(ext);
        
        List<int[]> list = new ArrayList();
        
        for(int [] d : data) {
            if(d[filterIndex] < val_ext) {
                list.add(d);
            }
        }
        
		int[][] answer = list.toArray(new int[0][]);
        
        int sortIndex = getIndex(sort_by);

		Arrays.sort(answer, Comparator.comparingInt(arr -> arr[sortIndex]));
        
        return answer;
    }
    
    
    private int getIndex(String ext) {
        switch(ext) {
            case "code" : return 0;
			case "date" : return 1;
			case "maximum" : return 2;
			default: return 3;
        }
    }
}