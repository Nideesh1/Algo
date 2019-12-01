class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return -1;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer> idxLevel = new HashMap<>();
        q.add(0);
        idxLevel.put(0,0);
        while(!q.isEmpty()){
            
            int idx = q.poll();
            int level = idxLevel.get(idx);
            
            for(int i = nums[idx]; i > 0; i--){
                int next = idx + i;
                if(next >= nums.length - 1){
                    return level + 1;
                }
                
                if(!idxLevel.containsKey(next)){
                    idxLevel.put(next, level + 1);
                    q.add(next);
                }
            }
            
        }
        
        return -1;
    }
}

//https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution/210384
