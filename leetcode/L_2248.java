class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Set<Integer> start = new HashSet<>();
        for (int o : nums[0]) start.add(o);
        if (nums.length == 1) {
            res = new ArrayList<>(start);
            Collections.sort(res); 
            return res;
        }
        
        for (int i = 1; i < nums.length; i++) {
            start = help(nums[i], start);
        }
        res = new ArrayList<>(start);
        Collections.sort(res); 
        return res;
    }
    
    public Set<Integer> help (int[] one, Set<Integer> set) {
        Set<Integer> temp = new HashSet<>();
        for (int o : one) temp.add(o);
        set.retainAll(temp);
        return set;
    }
}
