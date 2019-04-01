//DP Solution
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        for(int i = 0; i < nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
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
 
 
 
