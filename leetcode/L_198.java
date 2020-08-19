class Solution {
    Map<Integer,Integer> map;
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        map = new HashMap<>();
        return dfs(n-1);
    }
    public int dfs(int n){
        if(n < 0) return 0;
        if(map.containsKey(n)) return map.get(n);
        
        int back = dfs(n-1);
        int back2 = dfs(n-2) + nums[n];
        
        map.put(n, Math.max(back,back2));
        return map.get(n);
    }
}

class Solution {
    public int rob(int[] nums) { int n = nums.length;
        if( n == 0 ) return 0;
                                
        if(n == 1) return nums[0];
                                
        if(n == 2) return Math.max(nums[0], nums[1]);                        
                                
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);                                 
                                
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }                        
        return dp[n-1];
    }
}

//https://leetcode.com/problems/house-robber/
