class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;

            map.put(num, count);
        }

        // Heap or bucket List
        List<Integer>[] list = new ArrayList[nums.length + 1];
        
        for(Integer key : map.keySet()) {
            int count = map.get(key);

            if(list[count] == null) {
                list[count] = new ArrayList();
            }

            list[count].add(key);
        }

        List<Integer> answer = new ArrayList();

        for(int i = list.length - 1; i > 0 && k > 0; i--) {
            
            if(list[i] == null) {
                continue;
            }

            answer.addAll(list[i]);
            k -= list[i].size();
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}