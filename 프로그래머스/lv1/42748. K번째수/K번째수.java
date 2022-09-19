import java.util.Arrays;

class Solution {
    static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];
		
		while(left<=right) {
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			if(left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left >= right) return;
		
		int mid = partition(arr,left,right);
		
		quickSort(arr,left,mid-1);
		quickSort(arr,mid,right);
		
	}
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
        	
        	int[] sorted = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
        	
        	quickSort(sorted, 0, sorted.length-1);
        	answer[i] = sorted[commands[i][2]-1];
        }
        
        return answer;
    }
}