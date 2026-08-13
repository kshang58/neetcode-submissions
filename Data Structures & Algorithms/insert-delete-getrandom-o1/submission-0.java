class RandomizedSet {
    Map<Integer, Integer> hm;
    List<Integer> list;
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            hm.put(val, list.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        } else {
            int index = hm.get(val);
            list.set(index, list.get(list.size() - 1));
            hm.put(list.get(list.size() - 1), index);
            list.remove(list.size() - 1);
            hm.remove(val);
            return true;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */