class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int possible = 0;

        for(int i = 0; i < flowerbed.length; i++) {
            int curr = flowerbed[i];
            int prev = i - 1 >= 0 ? flowerbed[i - 1] : 0;
            int next = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
            
            if(prev == 0 && next == 0 && curr == 0) {
                flowerbed[i] = 1;
                possible++;
            }
        }

        return possible >= n;
    }
}