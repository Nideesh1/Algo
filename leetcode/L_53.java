class Solution {
    public int maxSubArray(int[] nums) {
        return recur(nums, 0, nums.length -1);   
    }
    
    public int recur(int[] nums, int i, int j ){
        if(i == j){
            return nums[i];
        }
        int m = (i+j)/2;
        int l = recur(nums, i, m);
        int r = recur(nums, m+1, j);
        
        int mix = mid(nums, i, m, j);
        return Math.max(mix, Math.max(l,r));
    }
    public int mid(int[] nums, int i, int m, int j){
        int lef = Integer.MIN_VALUE;
        int mlef  = 0;
        for(int k = m; k >= 0; k--){
            mlef += nums[k];
            if(mlef > lef){
                lef = mlef;
            }
        }
        int rig = Integer.MIN_VALUE;
        int mrig  = 0;
        for(int k = m; k < nums.length; k++){
            mrig += nums[k];
            if(mrig > rig){
                rig = mrig;
            }
        }
        return Math.max(lef, rig);
    }
}

//https://leetcode.com/problems/maximum-subarray/description/
