class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countMap = new HashMap();

        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if(!countMap.containsKey(ch)) {
                return false;
            }

            int count = countMap.get(ch);
            
            if(count == 0) {
                return false;
            }

            countMap.put(ch, count - 1);

        }

        return true;

    }
}