import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList();
        int max = Arrays.stream(candies).max().orElse(0);

        for(int i = 0; i < candies.length; i++) {
            answer.add(candies[i] + extraCandies >= max);
        }

        return answer;
    }
}