class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        for(int i : map.keySet()){
            if(!map.containsKey(i+1)) continue;
            int one = map.get(i);
            int two = map.get(i+1);
            max = Math.max(max, one + two);
        }
        System.out.println(max);
        return max;
    }
}

//https://leetcode.com/problems/longest-harmonious-subsequence/
