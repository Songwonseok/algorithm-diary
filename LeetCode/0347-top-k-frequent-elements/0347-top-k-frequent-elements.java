class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        int max = 0;

        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;

            map.put(num, count);

            max = Math.max(max, count);
        }

        // Heap or bucket List
        List<Integer>[] list = new ArrayList[max + 1];

        for(Integer key : map.keySet()) {
            int count = map.get(key);

            if(list[count] == null) {
                list[count] = new ArrayList();
            }

            list[count].add(key);
        }

        List<Integer> answer = new ArrayList();

        for(int i = list.length - 1; i >= 0; i--) {
            
            if(list[i] == null) {
                continue;
            }

            for(int num : list[i]) {
                answer.add(num);

                if(answer.size() == k) {
                    return answer.stream().mapToInt(v -> v).toArray();
                }
            }
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}