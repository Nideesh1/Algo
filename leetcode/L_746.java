//My solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int res = 0;
        //dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2])
        int[] dp = new int[cost.length];
        
        dp[0] = Math.min(cost[0], cost[1]);
        dp[1] = Math.min(cost[1] + dp[0], cost[1]);
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        int n = cost.length;
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[n-1], dp[n-2]);
    }
}

//LC Solution
class Solution {
    public int minCostClimbingStairs(int[] cost) { int n = cost.length;
        //dp[i] is cost ending till i 
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}

//https://leetcode.com/problems/min-cost-climbing-stairs/
