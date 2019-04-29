//my solution
class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        if(nums.length == 0) return;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++ ){
            dp[i] = nums[i] + dp[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return dp[j];
        return dp[j] - dp[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {
    int[] a;
    public NumArray(int[] nums) {
        a = nums;
    }
    
    public int sumRange(int i, int j) {
        int res = 0;
        for(int k = i; k <= j; k++){
            res += a[k];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 
 //https://leetcode.com/problems/range-sum-query-immutable/
 
 
 
