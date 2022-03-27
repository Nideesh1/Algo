//dp[i][j] means whether the specific sum j can be gotten from the first i numbers

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for(int i = 1; i < n + 1; i++){
            dp[i][0] = true;
        }
        
        for(int j = 1; j < sum + 1; j++){
            dp[0][j] = false;
        }
        
        for(int i = 1;  i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = (dp[i][j] || dp[i-1][j - nums[i-1]]);
                }
            }
        }
        
        return dp[n][sum];
    }
}

//https://leetcode.com/problems/partition-equal-subset-sum/discuss/90627/Java-Solution-similar-to-backpack-problem-Easy-to-understand
