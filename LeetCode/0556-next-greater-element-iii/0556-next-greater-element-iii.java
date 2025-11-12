class Solution {
    public int nextGreaterElement(int n) {
        char[] cArr = String.valueOf(n).toCharArray();
        int i = cArr.length - 2;

        // 1. 뒤에서부터 오름차순이 깨지는 지점 찾기
        while (i >= 0 && cArr[i] >= cArr[i + 1]) {
            i--;
        }
        if (i < 0) return -1; // 이미 가장 큰 수

        // 2. 뒤에서부터 cArr[i]보다 큰 수 중 최소값 찾기
        int j = cArr.length - 1;
        while (cArr[j] <= cArr[i]) {
            j--;
        }

        // 3. 스왑
        char temp = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = temp;

        // 4. i+1 이후 부분 오름차순 정렬
        Arrays.sort(cArr, i + 1, cArr.length);

        long result = Long.parseLong(new String(cArr));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }
}