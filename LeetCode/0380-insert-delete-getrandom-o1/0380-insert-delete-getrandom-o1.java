class RandomizedSet {
    private final HashMap<Integer, Integer> map;
    private final int[] range;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap();
        range = new int[200001];
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            range[map.size()] = val;
            map.put(val, map.size());
            return true;
        }

        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        int lastIdx = map.size() - 1;
        int lastVal = range[lastIdx];

        range[idx] = lastVal;
        range[lastIdx] = 0;

        map.put(lastVal, idx);

        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return range[random.nextInt(map.size())];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */