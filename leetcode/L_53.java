class Solution {
    public int maxSubArray(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }
    
    public int recur(int[] nums, int i , int j){
        if(i == j) return nums[i];
        int m = (i+j)/2;
        int l = recur(nums, i, m);
        int r = recur(nums, m+1,j);
        
        int mer = mer(nums, m);
        return Math.max(l, Math.max(r, mer));
    }
    
    public int mer(int[] nums,int m){
        int lmax = Integer.MIN_VALUE;
        int l = 0;
        for(int i = m; i >= 0; i--){
            l += nums[i];
            lmax = Math.max(lmax, l);
        }
        int rmax = Integer.MIN_VALUE;
        int r = 0;
        for(int i = m + 1; i < nums.length ; i++){
            r += nums[i];
            rmax = Math.max(rmax, r);
        }
        return Math.max(lmax + rmax,Math.max(lmax, rmax));
    }
    
}

class Solution {
    public int maxSubArray(int[] nums) {
        int cumSum = 0;
        int maxCum = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            cumSum += nums[i];
            
            maxCum = Math.max(maxCum, cumSum);
            cumSum = cumSum < 0 ? 0 : cumSum;
        }
        return maxCum;
    }
}

//https://leetcode.com/problems/maximum-subarray/description/
