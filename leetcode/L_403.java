class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for(int i = 0; i < stones.length; i++){
            for(int k : map.get(stones[i])){
                
                for(int step = k - 1; step <= k + 1; step++){
                    if(step > 0 && map.containsKey(step + stones[i])){
                        map.get(stones[i] + step).add(step);
                    }
                }
                
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

//https://leetcode.com/problems/frog-jump/solution/
