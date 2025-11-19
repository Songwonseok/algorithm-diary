class Solution {
    public List<String> buildArray(int[] target, int n) {
        int[] stack = new int[target.length];
        int idx = -1;

        List<String> ops = new ArrayList();
        int num = 1;

        while(!Arrays.equals(target, stack)) {
            if(idx == -1 || stack[idx] == target[idx]) {
                ops.add("Push");
                stack[++idx] = num++;
            }else{
                ops.add("Pop");
                stack[idx--] = 0;
            }
        }

        return ops;

    }
}