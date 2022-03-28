class Solution {
    public boolean canJump(int[] nums) {
        int lp = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= lp){
                lp = i;
            }
        }
        return lp == 0;
    }
}

enum Index{
    GOOD,BAD,UKNOWN
}
class Solution {
    Index[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i = 0; i < memo.length; i++){
            memo[i] = Index.UKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return dfs(0, nums);
    }
    
    public boolean dfs(int pos, int[] nums){
        if(memo[pos] != Index.UKNOWN){
            return memo[pos] == Index.GOOD ? true : false;
        }
        
        int max = Math.min(nums.length - 1, pos + nums[pos]);
        for(int next = pos + 1; next <=  max; next++){
            if(dfs(next, nums)) {
                memo[pos] = Index.GOOD; 
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }
}

enum Index{
    GOOD,BAD,UKNOWN
}

class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for(int i = 0; i < memo.length; i++){
            memo[i]= Index.UKNOWN;
        }
        
        memo[memo.length - 1] = Index.GOOD;
        for(int i = nums.length - 2; i >= 0; i--){
            int max = Math.min(nums.length - 1, i + nums[i]);
            for(int j = i + 1; j <= max; j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        
        return memo[0] == Index.GOOD;
    }
}

//https://leetcode.com/problems/jump-game/solution/


class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums, 0);
    }
    public boolean dfs(int[] nums, int pos) {
        if (pos == nums.length - 1) return true;
        if (dp[pos] != -1) return dp[pos] == 0 ? false : true;
        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        for (int next = furthest; next > pos; next --) {
            boolean res = dfs(nums, next);
            dp[next] = res == false ? 0 : 1;
            if (res) return true;
        }
        return false;
    }
}
