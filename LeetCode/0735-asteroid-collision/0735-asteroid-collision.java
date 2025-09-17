class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }

            if (!isPossibleCrush(curr, stack.peek())) {
                stack.push(curr);
                continue;
            }

            boolean isAlive = true;

            while (!stack.isEmpty()) {
                int prev = stack.pop();

                if(!isPossibleCrush(curr, prev)) {
                    stack.push(prev);
                    break;
                }

                int absCurr = Math.abs(curr);
                int absPrev = Math.abs(prev);

                if (absCurr > absPrev) {
                    continue;
                } else if (absCurr < absPrev) {
                    isAlive = false;
                    stack.push(prev);
                    break;
                } else {
                    isAlive = false;
                    break;
                }
            }

            if (isAlive) {
                stack.push(curr);
            }

        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    private boolean isPossibleCrush(int next, int prev) {
        return (next < 0 && prev > 0);
    }
}