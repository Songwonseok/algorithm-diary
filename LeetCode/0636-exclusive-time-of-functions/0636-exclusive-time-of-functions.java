class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack();
        int[] time = new int[n];

        for(String log : logs) {
            String[] split = log.split(":");

            int id = Integer.parseInt(split[0]);
            String ops = split[1];
            int timestamp = Integer.parseInt(split[2]);

            if(ops.equals("start")) {
                stack.push(new int[] {id, timestamp});
            }else {
                int[] startInfo = stack.pop();

                int diff = timestamp - startInfo[1] + 1;

                time[id] += diff;

                if(!stack.isEmpty()) {
                    time[stack.peek()[0]] -= diff;
                    continue;
                }
            }
        }

        return time;
    }
}