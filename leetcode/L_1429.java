class FirstUnique {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer,Boolean> unique = new HashMap<>();
    public FirstUnique(int[] nums) {
        for (int n : nums) add(n);
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty() && !unique.get(q.peek())) q.poll();
        
        if (!q.isEmpty()) return q.peek();
        return -1;
    }
    
    public void add(int value) {
        if(!unique.containsKey(value)) {
            unique.put(value, true);
            q.add(value);
        } else {unique.put(value, false);}
    }
}
