import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int[] numbers = new int[(int)Math.pow(2, nums.length)];    
        int binaryLength = nums[0].length();    


        for(int i = 0; i < nums.length; i++) {
            numbers[Integer.parseInt(nums[i], 2)]++;
        }

        String answer = "0";

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                answer = Integer.toBinaryString(i);
                break;
            }
        }

        return "0".repeat(binaryLength - answer.length()) + answer;

    }

}