class TimeMap {
    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(timestamp, value);
        List<Pair> hmv = hm.getOrDefault(key, new ArrayList<>());
        hmv.add(p);
        hm.put(key, hmv);
    }
    
    public String get(String key, int timestamp) {
        // base case
        List<Pair> hmv = hm.getOrDefault(key, new ArrayList<>());
        if (hmv.size() == 0) {
            return "";
        }
        // binary search O(nlogn)
        int l = 0;
        int r = hmv.size() - 1;
        while(l < r - 1) {
            int m = l + (r - l) / 2;
            Pair mp = hmv.get(m);
            if (mp.timestamp == timestamp) {
                return mp.value;
            } else if (mp.timestamp > timestamp) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        // postprocessing
        Pair mr = hmv.get(r);
        Pair ml = hmv.get(l);
        if (ml.timestamp > timestamp) {
            return "";
        } else if (mr.timestamp > timestamp) {
            return ml.value;
        } else {
            return mr.value;
        }
    }
}
