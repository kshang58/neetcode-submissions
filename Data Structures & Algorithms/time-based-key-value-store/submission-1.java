class TimeMap {
    class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> rslt = hm.getOrDefault(key, new ArrayList<Pair>());
        rslt.add(new Pair(value, timestamp));
        hm.put(key, rslt);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> rslt = hm.getOrDefault(key, new ArrayList<Pair>());
        if (rslt.isEmpty()) {
            return "";
        }
        int l = 0;
        int r = rslt.size() - 1;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (rslt.get(m).timestamp == timestamp) {
                return rslt.get(m).value;
            } else if (rslt.get(m).timestamp > timestamp) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (rslt.get(r).timestamp <= timestamp) {
            return rslt.get(r).value;
        } else if (rslt.get(l).timestamp <= timestamp) {
            return rslt.get(l).value;
        } else {
            return "";
        }
    }
}
