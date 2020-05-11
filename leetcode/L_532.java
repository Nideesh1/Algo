class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for(int m : map.keySet()){
            if(k == 0){
                if(map.get(m) >= 2) count++;
            }
            else
            {if(map.containsKey(m + k))
                count++;
            }
        }
        return count;
    }
}

//https://leetcode.com/problems/k-diff-pairs-in-an-array/discuss/100098/Java-O(n)-solution-one-Hashmap-easy-to-understand
