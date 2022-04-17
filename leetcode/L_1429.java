class FirstUnique {
    //key is num, val is true if unique
    Map<Integer,Boolean> map;
    Queue<Integer> q;
    public FirstUnique(int[] nums) {
        q = new LinkedList<>();
        map = new HashMap<>();
        for (int n : nums) {
            q.add(n);
            if (!map.containsKey(n)) {map.put(n, true);}
            else {map.put(n, false);}
        }
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && map.get(q.peek()) == false) {
            q.poll();
        }
        return q.peek() == null ? -1 : q.peek();
    }
    
    public void add(int value) {
        q.add(value);
        if (!map.containsKey(value)) {map.put(value, true);}
        else {map.put(value, false);}
    }
}
