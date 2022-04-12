class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        
        for(int i = 0; i < n - 1; i++){
            long cur = set.pollFirst();
            set.add(cur*2);
            set.add(cur*3);
            set.add(cur*5);
        }
        
        return set.first().intValue();
    }
}
