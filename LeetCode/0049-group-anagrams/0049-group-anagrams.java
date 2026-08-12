class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] copy = new String[strs.length];
        Map<String, List<Integer>> map = new HashMap();


        for(int i = 0; i < strs.length; i++) {
            char[] cArr = strs[i].toCharArray();

            Arrays.sort(cArr);
            String ordered = new String(cArr);
            copy[i] = ordered;

            List<Integer> idxList = map.getOrDefault(ordered, new ArrayList());
            idxList.add(i);
            
            map.put(ordered, idxList);
        }

        List<List<String>> answer = new ArrayList();

        for(String key : map.keySet()) {
            List<String> group = map.get(key).stream().map(i -> strs[i]).toList();

            answer.add(group);
        }

        return answer;
    }
}