class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    public int dfs(int[] nums, int i, int j){
        if(i == j) return nums[i];
        int m = (i+j)/2;
        int lef = dfs(nums, i, m);
        int rig = dfs(nums, m+1, j);
        int mid = mid(nums, i, m, j);
        return Math.max(mid, Math.max(lef,rig));
    }
    public int mid(int[] nums, int i, int m, int j){
        int lef = Integer.MIN_VALUE; int rig = Integer.MIN_VALUE;
        int temp = 0;
        for(int k = m; k >= i; k--){
            temp += nums[k]; lef = Math.max(lef, temp);
        }
        temp = 0;
        for(int k = m + 1; k <= j; k++){
            temp += nums[k]; rig = Math.max(rig, temp);
        }
        return lef + rig;
    }
}

//https://leetcode.com/problems/maximum-subarray/description/
