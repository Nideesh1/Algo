class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        int[] steps = {1,2};
        
        for(int i = 3; i <= n; i++){
            
            for(int j = 0; j < steps.length ;j++){
                dp[i] += dp[i - steps[j]];
            }
            
        }
        return dp[n];
    }
}

//https://leetcode.com/problems/climbing-stairs/
